class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1)  //base case
            return -1;
        
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        
        int result = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                
                if(curr[0] == m-1 && curr[1] == n-1)
                    return result+1;
                
                for(int[] dir: dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    
                    if(r >=0 && r < m && c >=0 && c < n && !visited[r][c] && grid[r][c] == 0){
                        q.add(new int[] {r, c});
                        visited[r][c] = true;
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
