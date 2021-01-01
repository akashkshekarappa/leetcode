class Solution {
    int m, n;
    public boolean exist(char[][] board, String word) {
        //edge case
        if(board == null || board[0].length == 0)
            return false;
​
        m= board.length;
        n= board[0].length;
        for(int i=0; i<m; i++){     // iterating over the board
            for(int j=0; j<n; j++){
                if(dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int index){
        //base case
        if(index == word.length())  return true;    // if reached the end of word
​
        if(i < 0 || j < 0 || i >=m || j >= n || board[i][j] == '#') return false;   // if out of bounds
​
        //logic
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        if(word.charAt(index) == board[i][j]){  // checking if the value is what is at word's index
            char temp = board[i][j];     // store it in local temp
            //action
            board[i][j] = '#';   //mark it vistied
​
            //recurse
            for(int[] dir: dirs){
                int r = dir[0] + i;
                int c = dir[1] + j;
​
                if(dfs(board, word, r, c, index+1))     // if the string is found return true at this point only
                    return true;
            }
​
            //backtrack
            board[i][j] = temp;     // reset value to local temp
        }
        return false;        
    }
}
