//TC: O(n)
//S: O(n-d), where D is a total length for all duplicates.
//We can use StringBuilder as a stack to avoid reversing
class Solution {
    public String removeDuplicates(String S) {
        StringBuilder stack = new StringBuilder(S.length());
        for(char c : S.toCharArray()){
            int size = stack.length();
            if(size > 0 && c == stack.charAt(size-1))
                stack.deleteCharAt(size-1);
            else
                stack.append(c);
        }
        return stack.toString();
    }
}

/*
Initiate an empty output stack.

Iterate over all characters in the string.

Current element is equal to the last element in stack? Pop that last element out of stack.

Current element is not equal to the last element in stack? Add the current element into stack.

Convert stack into string and return it.
*/