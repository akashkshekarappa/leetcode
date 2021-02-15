class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return new int[0];
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int row =0, column =0;
        
        int direction =1;
        
        int[] result = new int[m*n];
        int i=0;
        
        while(i < m*n){
            result[i] = matrix[row][column];
            
            if(direction == 1){
                if(column == n-1){
                    row++;
                    direction = -1;
                }
                else if(row == 0){
                    column++;
                    direction= -1;
                }
                else{
                    row--;
                    column++;
                }
            }
            else{
                if(row == m-1){
                    column++;
                    direction = 1;
                }
                else if(column == 0){
                    row++;
                    direction = 1;
                }
                else{
                    column--;
                    row++;
                }
            } 
            i++;
        }
        return result;
    }
}