//For each building find the nearest gate
class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0)
            return;
        
        for(int i=0; i<rooms.length; i++){
            for(int j=0; j<rooms[0].length; j++){
                if(rooms[i][j] == 0)
                    dfs(rooms, i, j);
            }
        }
    }
    private void dfs(int[][] rooms, int i, int j){
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for(int[] dir: dirs){
            int r = dir[0] + i; 
            int c = dir[1] + j;
            
            if(r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length || rooms[r][c] <= rooms[i][j])
                continue;
            
            rooms[r][c] = rooms[i][j] + 1;
            dfs(rooms, r, c);
        }
    }
}
