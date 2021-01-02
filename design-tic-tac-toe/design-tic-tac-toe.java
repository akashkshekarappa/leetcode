class TicTacToe {
​
    int[][] rows;
    int[][] cols;
    int[][] diagonal;
    int[][] antidiagonal;
    int n;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n][3];
        cols = new int[n][3];
        diagonal = new int[2 * n][3];
        antidiagonal = new int[2 * n][3];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        // 1 -> player1
        // 2 -> player2
        rows[row][player] += 1;
        cols[col][player] += 1;
        diagonal[row+col][player] += 1;
        antidiagonal[row - col + n][player] += 1;
        
        if(rows[row][player] == n || cols[col][player] == n || diagonal[row+col][player] == n || antidiagonal[row - col + n][player] == n)
            return player;
        
        else return 0;
    }
}
​
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
