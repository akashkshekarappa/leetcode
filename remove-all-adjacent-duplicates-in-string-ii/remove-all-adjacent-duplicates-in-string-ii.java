//Stack
//TC: O(n)
//SC: O(n)
class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<sb.length(); i++){
            if(i==0 || sb.charAt(i) != sb.charAt(i-1))  //if characters are not same, push 1 to the stack
                stack.push(1);
            
            else{
                int topValue = stack.pop() +1;
                if(topValue == k){ // If the count on the top of the stack equals k, erase last k characters and pop from the stack.
                    sb.delete(i - k + 1, i+1);
                    i = i-k;
                }
                else{
                    stack.push(topValue);
                }
            }
        }
        return sb.toString();
    }
}