//Using Stack
//TC: O(n)
//SC: O(n)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            //push closing bracket corresponding to open ones 
            if(c == '(')
                st.push(')');
            else if(c == '{')
                st.push('}');
            else if(c == '[')
                st.push(']');
            else if(st.isEmpty() || st.pop() != c)
                return false;
        }
        return st.isEmpty(); // if stack is empty then it is valid
    }
}