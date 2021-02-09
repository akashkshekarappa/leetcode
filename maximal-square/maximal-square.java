//Dynamic programming
// Time Complexity : O(m * n), m and n are rows and col, single pass
// Space Complexity : O(m * n), dp matrix of same size used
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
			return 0;
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];  // extra row and col, because dp matrix first row and col will be filled with zero
		int max = Integer.MIN_VALUE;
		//process all elements of matrix
		for(int i=1; i<=matrix.length; i++){
			for(int j=1; j<=matrix[0].length; j++){
				if(matrix[i-1][j-1] == '1'){    //if the original array value has 1
					dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
					if(max < dp[i][j])
						max = dp[i][j]; //updating the max value
				}
			}
		}
		return max * max;
    }
}