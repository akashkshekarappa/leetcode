class Solution {
    int result = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
      
        
         int count = 0;
        
         for(int i=0; i<grid1.length; i++){
            for(int j=0; j<grid2[0].length; j++){
                if(grid2[i][j] == 1){  // if encountered 1
                    result = 1;
                    dfs(grid1, grid2, i , j);
                    count+=result;    // increase the count only for new island found
                    
                }
            }
         }
        return count;
    }
    private void dfs(int[][] grid1, int[][] grid2, int i, int j){
        //base case
        if(i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length || grid2[i][j] == 0)
            return;
   
        if(grid1[i][j] == 0)
            result = 0;
        //logic
        int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        grid2[i][j] = 0;   // mark visited
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid1, grid2, r, c);    //call dfs on all neighbours
        }
    }
}