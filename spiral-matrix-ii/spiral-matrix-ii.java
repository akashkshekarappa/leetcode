// Time Complexity : O(m*n)
// Space Complexity : O(1)
/* For traversing we use direction, 
 * First we traverse topmost row of the untraversed array from left to right , we need to change the direction when we can't traverse right further, we then increment the top and change direction to 1; 
 * similarly we do with other directions;*/
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if(n == 0)
            return result;
        int top = 0;
        int bottom = n -1;
        int left = 0;
        int right = n -1;
        int direction = 0;
        int numbers = 1;
        
        while(top <= bottom && left <= right){
            if(direction  == 0){
                for(int i=left; i<=right; i++){
                    result[top][i] = numbers++;
                }
                top++;
                direction = 1;
            }
            else if(direction == 1){
                for(int i=top; i<=bottom; i++){
                    result[i][right] = numbers++;
                }
                right--;
                direction = 2;
            }
            else if(direction == 2){
                for(int i=right; i>=left; i--){
                    result[bottom][i] = numbers++;
                }
                bottom--;
                direction = 3;
            }
            else if(direction == 3){
                for(int i=bottom; i>=top; i--){
                    result[i][left] = numbers++;
                }
                left++;
                direction = 0;
            }
        }
        return result;        
    }
}
​
