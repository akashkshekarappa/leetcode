class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(char s : stack) 
            sb.append(s);
        return sb.toString();
    }
}
​
/*
Initiate an empty output stack.
​
Iterate over all characters in the string.
​
Current element is equal to the last element in stack? Pop that last element out of stack.
​
Current element is not equal to the last element in stack? Add the current element into stack.
​
Convert stack into string and return it.
*/
