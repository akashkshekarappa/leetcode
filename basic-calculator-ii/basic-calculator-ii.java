/***Using stack, if we find a sign, means we are done with the number and push the number into stack along with sign
 * if the last number was a multiplication/division, we pop from the stack and multiply/divide and add to stack
 * at last we add all numbers left in the stack**/
//TC:O(n), length of string
//SC: O(n)
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char last_sign = '+';
        int number = 0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = number * 10 + (c - '0');
            }
            
            if((!Character.isDigit(c) && c!= ' ') || i == s.length()-1){ //if its not a digit and not having space, or its last digit then has to be added to stack
                if(last_sign == '+')
                    stack.push(number);
                else if(last_sign == '-')
                    stack.push(-number);
                else if(last_sign == '*')   // if it is division/multiplication, pop the last number and perform division/multiplication with current number and push back
                    stack.push(stack.pop() * number);
                else if(last_sign == '/')
                    stack.push(stack.pop() / number);
                
                number = 0; //reset
                last_sign = c;  // put last sign as current sign
            }   
        }
        // now adding all numbers left in stack
        int result = 0;
        while(!stack.isEmpty()){
            result+= stack.pop();
        }
        return result;
    }
}
