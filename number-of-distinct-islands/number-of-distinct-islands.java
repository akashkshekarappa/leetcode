//DFS, o - start, and move 0 - right, 1 - down, 2 - left, 3 - up.
//TC: O(m * n)
//SC: OO(m * n)
class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        Set<String> set = new HashSet<>();  //unique shapes
        StringBuilder sb;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    sb = new StringBuilder("o");
                    dfs(grid, i, j, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    private void dfs(int[][] grid, int i, int j, StringBuilder sb){
        
        for(int[] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length){
                if(grid[r][c] == 1){
                    grid[r][c] = 0;
                    sb.append(dir);
                    dfs(grid, r, c, sb);
                }
            }
        }
        sb.append("_");
    }
}
