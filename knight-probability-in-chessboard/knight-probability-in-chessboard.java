//TC: O(n^2 K)
//SC: O(n^2)
class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] dirs = new int[][] {{2,1}, {-2, 1}, {2, -1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}};
        
        double result = 0;
        
        double[][] dp = new double[N][N];
        dp[r][c] = 1;
        
        for(int k=1; k<= K; k++){
            double[][] newDp = new double[N][N];
            
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    for(int[] dir: dirs){
                        int row = i-dir[0];
                        int col = j-dir[1];
                        
                        if(row >= 0 && col >= 0 && row < N && col < N){
                            newDp[i][j] += dp[row][col] / 8.0;
                        }
                    }
                }
            }
            dp = newDp;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++)
                result += dp[i][j];
        }
        return result;
    }
}