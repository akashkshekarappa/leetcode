//DFS
//TC:O(m n)
//SC: O(m n)
class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    if(dfs(grid, i, j))
                        count++;
                }
            }
        }
        return count;
    }
    private boolean dfs(int[][]grid, int i, int j){
        if(i < 0 ||i >= grid.length || j < 0 ||  j >= grid[0].length)
            return false;
        
        if(grid[i][j] == 1)
            return true;
        grid[i][j] = 1;
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        boolean isClosed = true;
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
        
            isClosed = isClosed & dfs(grid, r, c);
        }
        return isClosed;
    }
}
