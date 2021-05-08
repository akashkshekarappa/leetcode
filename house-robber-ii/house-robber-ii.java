//Dynamic programming
//TC: O(n)
//SC: O(n)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        if(nums.length == 1)				
        	return nums[0];
        //set two dp arrays
        //dp--> the first element is used
        //dp2 --> the first element is not used
        
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        //pretend first element is not used by initilize it as 0
        dp2[0] = 0;
        dp2[1] = nums[1];
        
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i] , dp[i-1]);
            dp2[i] = Math.max(dp2[i-2] + nums[i], dp2[i-1]);
        }
        
        // for dp[] if we use the first element, the last element cnanot be used, 
        //so the largest profit is max(dp[n-2],dp2[n-1])
        return Math.max(dp[nums.length-2], dp2[nums.length-1]);
    }
}