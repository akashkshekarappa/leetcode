class Solution {
    List<List<String>> result;
    int m;
    int[][] board;  //board to store where queens are placed
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];  //initilaizing board to n*n
        m=n;
        
        backtrack(0);   //calling backtracking func on 0th row
        
        return result;
    }
    private void backtrack(int r){
        //base case
        if(r == m){ // if we crossed last row
            List<String> list = new ArrayList<>();
            for(int i =0; i<m; i++){    //iterating throught the board
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<m; j++){
                    if(board[i][j] == 1)
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                list.add(sb.toString());
            }
            result.add(list);
        }
        
        //logic
        for(int c=0; c<m; c++){
            //trying to put queen at a particular column
            if(isSafe(r, c)){
                //action
                board[r][c] = 1;    //if its safe, place the queen
                //recurse
                backtrack(r+1);     // go to next row
                //backtrack
                board[r][c] = 0;    // invalid path, so backtrack the move inserting the queen
            }
        }
    }
    private boolean isSafe(int r, int c){
        //same column , up direction
        for(int i=0; i<r; i++){
            if(board[i][c] == 1)    // checking for the column if queen is already present it will block
                return false;  
        }
        //diagonal up right
        int i = r-1, j = c+1;
        while(i >= 0 && j < m){
            if(board[i][j] == 1)
                return false;
            
            i--;
            j++;
        }
         //diagonal up left
        i = r-1 ; j = c-1;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 1)
                return false;
            
            i--;
            j--;
        }
        return true;
    }
}