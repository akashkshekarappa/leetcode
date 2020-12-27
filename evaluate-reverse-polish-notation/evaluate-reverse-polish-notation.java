//Using stack
//TC: O(n)
//SC: O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            if("+-*/".contains(tokens[i])){
                int y = st.pop();
                int x = st.pop();
                if(tokens[i].equals("+"))
                    st.push(x + y);
                else if(tokens[i].equals("-"))
                    st.push(x - y);
                else if(tokens[i].equals("*"))
                    st.push(x * y);
                else if(tokens[i].equals("/"))
                    st.push(x / y);
            }
            else
                st.push(Integer.parseInt(tokens[i]));
        }
        return st.pop();
    }
}
