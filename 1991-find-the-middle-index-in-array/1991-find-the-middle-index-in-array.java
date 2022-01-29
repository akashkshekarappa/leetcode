//Approcah prefix and suffix sum
//TC: O(n)
//SC: O(1)
class Solution {
    public int findMiddleIndex(int[] nums) {
        if(nums == null || nums.length == 0)    // base condition
            return -1;
        
        int totalSum = 0;
        for(int i=0; i<nums.length; i++)
            totalSum += nums[i];
        
        int prefix =0, suffix = 0;
        for(int i=0; i<nums.length; i++){
            suffix = totalSum - prefix;
            prefix += nums[i];
            
            if(prefix == suffix)
                return i;
        }
        return -1;
    }
}