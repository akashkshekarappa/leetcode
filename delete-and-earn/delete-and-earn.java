class Solution {
    public int deleteAndEarn(int[] nums) {  //nums: [3,4,2]

        if(nums == null || nums.length == 0)
            return 0;
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++)    	//iterate and store the max of each
            max = Math.max(max, nums[i]);   //max: 4

        
        int[] earned = new int[max+1];  //earned: [0,0,0,0,0]
        for(int i=0; i<nums.length; i++)
            earned[nums[i]] = earned[nums[i]] + nums[i];  //earned:[0,0,2,3,4]//if we encounter the number, then add the index to array earned
        
        int[][] dp = new int[max+1][2]; //dp: [[0,0],[0,0],[0,0],[0,0],[0,0]]
        for(int i=1; i<dp.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);// if we dont choose, then get the max from previous row(similar to house robber)
            dp[i][1] = earned[i] + dp[i-1][0];  //if we choose, add the earned/current value with previous row not choosen value
        }
        return Math.max(dp[max][0], dp[max][1]);    //dp: [[0,0],[0,0],[0,2],[2,3],[3,6]]

    }
}