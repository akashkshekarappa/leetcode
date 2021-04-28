//Approac: Transpose and then reverse
//TC: O(n^2)
//SC: O(1)
class Solution {
    public void rotate(int[][] matrix) {
       // Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //Step: Transpose , turns rows to column (matrix: [[1,4,7],[2,5,8],[3,6,9]])
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //Step: reverse each row
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length/2; j++){  // by 2 because we only reach till mid and swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 -j];
                matrix[i][matrix.length - 1 -j] = temp;
            }
        }
    }
}