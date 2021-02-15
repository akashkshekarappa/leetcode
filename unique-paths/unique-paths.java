//TC : O( m * n)
//SC : O( m * n)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; //dp matrix
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 1;   // for first row and col fill it with 1
                
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]; // add prev col val with prev row val
            }
        }
        return dp[m-1][n-1];    // return last cell value
    }
}