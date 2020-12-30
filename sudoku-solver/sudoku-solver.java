//Backtracking
//TC: O(9 ^ m) => O(1) ,m represents the number of blanks to be filled in
//SC: the board size is fixed, and the space is used to store board, rows, columns and boxes structures, each contains 81 elements.
class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)//base case
            return;
        solve(board);
    }
    private boolean solve(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c ='1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;    //put c for this cell
                            
                            if(solve(board))
                               return true; //if it is the soln, returns true
