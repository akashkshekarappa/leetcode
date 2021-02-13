//TC: O(n)
//SC: O(n)
class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '('){
                stack.push(sb);
                sb = new StringBuilder();
            }
            else if(c == ')') {
                String reverse = sb.reverse().toString();
                sb = stack.pop();
                sb.append(reverse);
            }
            else
                sb.append(c);
            
        }return sb.toString();
    }
}