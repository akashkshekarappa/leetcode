//BFS
//TC: O(m * n)
//SC: O(m * n)
class Solution {
    public int maxDistance(int[][] grid) {
        if(grid == null || grid.length == 0)    //base case
            return 0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1)
                    q.add(new int[]{i, j});
            }
        }
        
        if(q.size() == 0 || q.size() == grid.length * grid[0].length)
            return -1;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int max = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                
                for(int[] dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    
                    if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 0){
                        grid[r][c] = 1;
                        q.add(new int[] {r,c});
                    }      
                }
            }
            max++;
        }
        return max-1;
    }
}
