//DFS
//Time Complexity : O(m * n)
//Space Complexity : O(m * n)
class Solution {
    static int m;
    static int n;
    static int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
       //edge case
        if(maze == null || maze.length == 0)
            return false;
​
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][] {{0,1},{-1,0},{1,0},{0,-1}};
​
        maze[start[0]][start[1]] = 2;   // mark the starting position as visited
        return dfs(maze, start, destination);
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination) {
        //base
        if(start[0] == destination[0] && start[1] == destination[1]) {  // when the start of dfs becomes destination
            return true;    //return true if reached destination
        }
​
        //logic
        for(int[] dir: dirs) {
            int r = start[0];   //source cell indices
            int c = start[1];
            while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                r = r + dir[0];
                c = c + dir[1];
            }
            //bring the ball to actual child, i.e one behind the obstacle
            r = r - dir[0]; // we stop when we reach a wall i.e 1 so we have to give a index prior to that
            c = c - dir[1];
​
            if(maze[r][c] != 2) {   //if position is not visited
                maze[r][c] = 2;
​
                if(dfs(maze, new int[] {r,c}, destination)) // start dfs on the new starting index, if it returns true at any point return true
                    return true;
            }
        }
        return false;
    }
}
