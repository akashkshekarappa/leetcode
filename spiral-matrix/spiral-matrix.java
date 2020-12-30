// Time Complexity : O(m*n)
// Space Complexity : O(1)
/* For traversing we use direction, 
 * First we traverse topmost row of the untraversed array from left to right , we need to change the direction when we can't traverse right further, we then increment the top and change direction to 1; 
 * similarly we do with other directions;*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return result;
        int top = 0;
        int bottom = matrix.length -1;
        int left = 0;
        int right = matrix[0].length -1;
        int direction = 0;
        
        while(top <= bottom && left <= right){
            if(direction  == 0){
                for(int i=left; i<=right; i++){
                    result.add(matrix[top][i]);
                }
                top++;
                direction = 1;
            }
            else if(direction == 1){
                for(int i=top; i<=bottom; i++){
                    result.add(matrix[i][right]);
                }
                right--;
                direction = 2;
            }
            else if(direction == 2){
                for(int i=right; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                direction = 3;
            }
            else if(direction == 3){
                for(int i=bottom; i>=top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
                direction = 0;
            }
        }
        return result;
    }
}
