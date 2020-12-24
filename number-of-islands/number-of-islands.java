class Solution {
    //int count;
    public int numIslands(char[][] grid) {
        //edge case
        if(grid == null || grid.length == 0)
            return 0;
        
         int count = 0;
        
         for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){  // if encountered 1
                    count++;    // increase the count only for new island found
                    dfs(grid, i , j);
                }
            }
         }
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        //base case
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
   
        //logic
        int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        grid[i][j] = '0';   // mark visited
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c);    //call dfs on all neighbours
        }
    }
}
