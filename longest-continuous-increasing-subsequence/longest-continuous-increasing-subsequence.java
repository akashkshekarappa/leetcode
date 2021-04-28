//more of sliding window approach
//TC: O(n)
//SC: O(1)

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int result = 0;
        int pt = 0;
        
        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i-1] >= nums[i])
                pt = i;
            
            result = Math.max(result, i - pt +1);
        }
        return result;
    }
}