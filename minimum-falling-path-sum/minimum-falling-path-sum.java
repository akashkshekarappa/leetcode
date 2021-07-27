/*Here we will be having 3 cases the first one when we are going to the next row in the 0th column the second case when we will be going to the next row in the last column and the third case is going to be the one when we will be going to the next row in any of the columns in between first and the last one . so what we will be doing is we will store the total cost(value) for jumping to that particular location and in the end whatever is going to be the minimum cost in the last row will be giving us the minimum cost to reach there.*/
// Time Complexity : O(m*n) ; the size of matrix
// Space Complexity : O(1)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];
        
        for(int i=0; i<matrix.length; i++)
            dp[0][i] = matrix[0][i];// inserting the elements to first row
        
        for(int i=1; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                // case1: if column's first value is 0, then add the element with min (previous row , previous row +1 element)
                if(j == 0)     
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j] , dp[i-1][j+1]);
                
                // case2: choosing last value, then add the element with min (previous row , previous row -1 element)
                else if(j == matrix.length -1)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                
                //case 3: else, choosing middle value, then add the element with min (previous row, previous row -1, previous row +1 element)
                else
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1]));
            }
        }
        // return the min of last row
        int min = Integer.MAX_VALUE;
        for(int i=0; i<matrix.length; i++){
            if(min > dp[matrix.length-1][i])
                min = dp[matrix.length-1][i];
        }
        return min;
    }
}