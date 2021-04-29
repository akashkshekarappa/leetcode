//TC: O(n^2 + nlogn)
//SC: O(1)
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int result = 0;
        for(int i=0; i<nums.length; i++){
            int low = i+1;
            int high = nums.length-1;
            
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if(sum < target){
                    result+= high - low;
                    low++;
                }
                else high--;
            }
        }
        return result;
    }
}