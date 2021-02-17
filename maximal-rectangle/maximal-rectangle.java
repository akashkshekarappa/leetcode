class Solution {
    public int maximalRectangle(char[][] matrix) {
        //edge case
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int max = 0;        
        int[] height = new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == '0'){    //if it's zero, then retain same
                    height[j] = 0;
                }
                else{
                    height[j] += 1; //else increment height by 1
                }
            }
            max = Math.max(max, findArea(height));
        }
        return max;        
    }
    
    private int findArea(int[] height){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);   //add index of first element
        for(int i=1; i<height.length; i++){
            int curr = height[i];   //current element
            
            if(stack.isEmpty() || curr >= height[stack.peek()]){    //if stack is empty, or curr element is greater than element at top of stack
                stack.add(i);
            }
            else{   // keep popping till stack is not empty and current element is less than element at top of stack
                while(!stack.isEmpty() && curr < height[stack.peek()]){
                    int temp = height[stack.pop()];
                    if(stack.isEmpty()){
                        max = Math.max(max, temp * i);
                    }
                    else{
                        max = Math.max(max, temp * (i - stack.peek()-1));
                    }
                }
                
                stack.add(i);
                
            }
        }
        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
                int  i = height.length;
                int temp = height[stack.pop()];
                if(stack.isEmpty()){
                    max = Math.max(max, temp * i);
                }
                else{
                    max = Math.max(max, temp * (i - stack.peek()-1));
                }
            }
        }
        return max;
    }
}