/*considering mid point as the top right corner. 
 * If the element at mid is greater than target, then search towards the left column
 * If the element is greater than target, then search towards the next row 
 * If pointers move out of the matrix means target is not present, so return false.*/
// Time Complexity : O(m + n)
// Space Complexity : O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n-1;     // index of top right corner
        while(i < m && j >= 0){
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)  // if current number is greater than target, move to the left column
                j--;    
            else    // if current number is less than target, move to the next row
                i++;
        }
        return false;
    }
}
