// Time Complexity : O(n)
// Space Complexity : O(n)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0)		// if given arrray is null or length = 0 , return 0
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        
        int[] dp = new int[nums.length];// initializing a 1d array
        dp[0] = nums[0];//considering first house is most I can rob
        dp[1] = Math.max(nums[0], nums[1]); //to consider second house, find the max of first and second house
        for(int i=2; i<nums.length; i++){// to consider from 3rd house, will find the max of (i-2 + i and i-1) 
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];// return the max value
    }
}