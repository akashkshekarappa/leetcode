class Solution {
    List<List<String>> result;
    int m;
    int[][] board;
    public int totalNQueens(int n) {
        result= new ArrayList<>();
        m = n;
        board = new int[n][n];
        backtrack(0);
        return result.size();
    }
    private void backtrack(int r){
        //base case
        if(r == m){
            List<String> list = new ArrayList<>();
            for(int i=0; i<m; i++){
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
            if(isSafe(r,c)){
                //action
                board[r][c] = 1;
                //recurse
                backtrack(r+1);
                //action
                board[r][c] = 0;
            }
        }
    }
    private boolean isSafe(int r, int c){
        //same column, up direction
        for(int i=0; i<r; i++){
            if(board[i][c] == 1)
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
        i=r-1; j=c-1;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 1)
                return false;
            
            i--;
            j--;
        }
        return true;
    }
}