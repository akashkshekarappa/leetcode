//Time Complexity : O(n)
//Space Complexity : O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3)
            return 0;
        
        int sum = 0;
        int dp = 0;
        for(int i=2; i<nums.length; i++){
            if(nums[i-1] - nums[i-2] == nums[i] - nums[i-1]){
                dp++;
                sum+= dp;
            }
            else
                dp = 0;
        }
        return sum;
    }
}