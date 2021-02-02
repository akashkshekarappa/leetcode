//TC: O(m * n)
//SC: O(m * n)
class Solution {
    int[][] dirs;
    int m;
    int n;
    public char[][] updateBoard(char[][] board, int[] click) {
        //base case
        if(board == null || board.length == 0)  return board;
        m = board.length; n = board[0].length;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        //Rule 1: if click is on mine only
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfs(board, click[0], click[1]);
        return board;
    }
    
    private void dfs(char[][] board, int i, int j){
        //base case
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'E')
            return;
        
        //logic
        board[i][j] = 'B';
        int mines = getMines(board, i, j);
        if(mines == 0){
            for(int[] dir: dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                dfs(board, r, c);
            }
        }
        else{
            board[i][j] = (char)(mines + '0');
        }
    }
    
    private int getMines(char[][] board, int i, int j){
        int count = 0;
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && r < m && c >= 0 && c < n && board[r][c] == 'M'){
                count++;    //increment if its mine
            }
        }
        return count;
    }
}