// Time Complexity :O( n * T), n = number of coins, t = amount target
// Space Complexity : O(T)
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i=0; i<=coins.length; i++)
			dp[i][0] = 1;
        
        for(int j=1; j<=amount; j++)
            dp[0][j] = 0;
        
        for(int i=1; i<=coins.length; i++){
            for(int j=1; j<=amount; j++){
                if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        return dp[coins.length][amount];
    }
}