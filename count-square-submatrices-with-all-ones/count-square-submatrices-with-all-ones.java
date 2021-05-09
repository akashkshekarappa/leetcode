//Dynamic programming
// Time Complexity : O(m * n), m and n are rows and col, single pass
// Space Complexity : O(1)

class Solution {
    public int countSquares(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
			return 0;
		int count = 0;
		//process all elements of matrix
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(matrix[i][j] > 0 && i > 0 && j > 0)
					matrix[i][j] = 1 + Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]));
				
                count+= matrix[i][j];
			}
		}
		return count;
    }
}