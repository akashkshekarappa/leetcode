//DFS Approach, recursive
//TC: O(m * n)
//SC: O(m * n)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //edge case
        if(grid == null || grid.length == 0)
            return 0;
        
        int result= 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){  // if encountered 1
                    result = Math.max(result, dfs(grid, i , j));
                    
                }
            }
         }
        return result;
    }
    
    private int dfs(int[][] grid, int i, int j){
        //base case
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 0;
   
        //logic
        int result =1;
        int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        grid[i][j] = 0;   // mark visited
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            result+= dfs(grid, r, c);    //call dfs on all neighbours
        }
        return result;
    }
}
