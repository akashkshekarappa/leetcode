/* 
* If current live cell is becoming dead, instead of making it 0 which will loose the state, make it 3(1 --> 0 = 3 ), 
 * if cell becomes dead from live change to 3 so we know it was live.
 * If current dead cell is becoming live, make it 2(0 --> 1 = 2 ), 
 * if cell becomes live from dead change to 2 so we know it was dead.
 * Replace 3 by 0 and 2 by 1 to get the final output.
 */
class Solution {
    public void gameOfLife(int[][] board) {
        //values in 8 Direction left,right,top,down,top left ,top right,bottom left, bottom right  
         int[][] direction={{0,-1},{0,1},{1,0},{1,-1},{1,1},{-1,-1},{-1,1},{-1,0}};
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                int live = 0;   // to count lives
                
                for(int[] d : direction){
                    if((i+d[0]) < 0 || (i+d[0]) >= board.length || (j+d[1]) < 0 || (j+d[1]) >= board[0].length)
                        continue;
                    
                    if( board[i+d[0]][j+d[1]] == 1 || board[i+d[0]][j+d[1]] == 3 )  // 1 -> currently alive, 3-> alive before
                        live++;
                }
                if(board[i][j] == 1 && (live < 2 || live > 3))  // if cell is live and 1]Any live cell with fewer than two live neighbors dies 3]Any live cell with more than three live neighbors dies
                    board[i][j] = 3;    // 1 --> 0 = 3
                    
                if(board[i][j] == 0 && (live == 3)) //if cell is dead, 0 --> 1 = 2 
                    board[i][j] = 2;
            }
        }
        
        //Replace 3 by 0 and 2 by 1
        for(int i= 0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 3)
                    board[i][j] = 0;
                if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }  
    }
}
