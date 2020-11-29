//TC: O(n)
//SC: O(1)
​
//Initially, the robot is at (x, y) = (0, 0). If the move is 'U', the robot goes to (x, y-1); if the move is 'R', the robot goes to (x, y) = (x+1, y), and so on.
​
class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for(char move: moves.toCharArray()){
            if(move == 'U')
                y++;
            else if(move == 'D')
                y--;
            else if(move == 'L')
                x--;
            else if(move == 'R')
                x++;
        }
        return x == 0 && y == 0;
    }
}
