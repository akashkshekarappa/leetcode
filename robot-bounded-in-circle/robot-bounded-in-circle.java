//TC: O(N)
//SC: O(1)
class Solution {
    public boolean isRobotBounded(String instructions) {
        //edge case
        if(instructions == null || instructions.length() == 0)
            return true;
                                    //N    //W      //S     //E        
        int[][] dir =  {{0,1}, {-1,0}, {0,-1}, {1,0}};
        int x = 0;
        int y = 0;
        int i = 0; 
        for(int k=0; k<instructions.length(); k++){
            char c = instructions.charAt(k);
            if(c == 'L')
                i = (i + 1) % 4;
            else if(c == 'R')
                i = (i + 3) % 4;
            else{ //G
                x = x + dir[i][0];
                y = y + dir[i][1];
            }
        }
        return i != 0 || (x == 0 && y == 0);
    }
}