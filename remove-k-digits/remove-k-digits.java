// Time Complexity :O(n), length of string num
// Space Complexity : O(n), size of stack
​
/**We add the digits to stack. 
 * If at any time the next digit is less than top element of stack, pop the element from stack to maintain curve
 * At the end reverse the elements of stack and return the output
 * **/
​
class Solution {
  public String removeKdigits(String num, int k) {
        if(k >= num.length())
            return "0";
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<num.length(); i++){
            Integer c = num.charAt(i) - '0';
            while(!st.isEmpty() && st.peek() > c && k > 0){
                st.pop();
                k--;
            }
            if(st.isEmpty() && c == 0)
                continue;
            else
                st.push(c);
        }
        while(k > 0){
            st.pop();
            k--;
        }
            
        StringBuilder result = new StringBuilder();
        while(!st.isEmpty()){
            result.append(st.pop());
        }
      if(result.length() == 0)
           return "0";
      else
          return result.reverse().toString();
    }
}
