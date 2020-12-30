/***The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces **/
​
//Time Complexity : O(n), length of string
//Space Complexity : O(n), length of string
class Solution {
    public int calculate(String s) {
       Stack<Integer> stack = new Stack<Integer>();
        int number  = 0;
        int result = 0;
        int sign = 1;   //1 = +ve, -1 = -ve
​
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = number * 10 + (c - '0');
            }
            else if(c == '+'){
                result += sign * number;
                sign = 1;   //recently encountered '+' sign
                number = 0; //reset number
            }
            else if(c == '-'){
                result += sign * number;
                sign = -1;   //recently encountered '-' sign
                number = 0; //reset number
            }
            else if(c == '('){
                //push result and then sign if opening braces found
                stack.push(result);
                stack.push(sign);
                //reset sign and result, if we have to evaluate for new sub expression
                sign = 1;
                result = 0;
            }
            else if(c == ')'){
                // if its closing braces, evaluate the expression to the left
                result += sign * number;
​
                result *= stack.pop();//result is multiplied with sign on top of stack
                result+= stack.pop();// then added to next operand on the top
                number = 0; //reset number
            }
        }
        return result + (sign * number);
    }
}
