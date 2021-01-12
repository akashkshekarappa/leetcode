// Time Complexity :O( n * T), n = number of coins, t = amount target
// Space Complexity : O( n * T)
class Solution {
    public int coinChange(int[] coins, int amount) {
      int[][] dp = new int[coins.length+1][amount+1];       //2d array, coin and amount, to avoid overlapping sub-problems
        
        for(int i=1; i<=coins.length; i++)          // 1st column is initialized with 0, since 0 amount can be made using 0 coins
            dp[i][0] = 0;
        
        for(int j=1; j<=amount; j++)            // 1st row is initialized with infinity, as it denomination 0
            dp[0][j] = 99999;
        
        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                if(coins[i-1] > j) {            // if current cell above row value is greater than amount, then value of the cell would be previous row's extract
                    dp[i][j] = dp[i-1][j];
                }
                else                            //else it would be minimum of (previous row (same column) value, 1 + column minus coinValue (same row))
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
            }
        }
        
        int minCoins = dp[coins.length][amount];            //last cell value
        if(minCoins >= 99999)
            return -1;
        else
            return minCoins;        //returning last cell value
    }
}
​
/*
   0  1     2     3      4    5      6    7     8     9     10     11
0 [0,99999,99999,99999,99999,99999,99999,99999,99999,99999,99999,99999]
    
1 [0, 1,     2,    3,    4,   5,     6,   7,    8,    9,    10,    11]
​
2 [0, 1,     1,    2,    2,   3,     3,   4,    4,    5,     5,    6]
​
5 [0, 1,     1,    2,    2,   1,     2,   2,    3,    3,     2,    3(output)] 
​
*/
