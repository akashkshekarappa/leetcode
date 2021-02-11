//Top right corner approach
//TC: O(m + n)
//S: O(1)
class Solution {
    public int countNegatives(int[][] grid) {
        int row = 0;
        int col = grid[0].length -1;
        int count = 0;
        
        while(row < grid.length && col >= 0){
            if(grid[row][col] < 0){
                col--;
                count += grid.length - row;// there are m - r negative numbers in current column.
            }
            else
                row++;
        }
        return count;
    }
}