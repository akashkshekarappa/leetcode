/*
For this example "bcacb"

Step 1: the stack is empty, add 'b'. current string: "b"
Step 2: 'c' is bigger than 'b', add it to stack. current string: "bc"
Step 3: 'a' is smaller than 'c', there is still 'c' after this 'a'. so pop it. The same for 'b' as well. So pop it. current string: "a"
Step 4: 'c' is bigger than 'a', add it to stack. current string: "ac"
Step 5: 'b' is smaller than 'c", howerver, there is no 'c' after 'b'. We can't pop 'c', add 'b'. current string: "acb"
So the result is 'acb'
*/
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] lastPos = new int[26];    //the last pos of the char
        boolean[] added = new boolean[26];  //if the char is added to the result
        
        for(int i=0; i<s.length(); i++){
            lastPos[s.charAt(i) - 'a'] = i;
        }
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(added[c - 'a'])
                continue;
            
            while(!stack.isEmpty() && stack.peek() > c && lastPos[stack.peek() - 'a'] > i){
                added[stack.peek() - 'a'] = false;
                stack.pop();
            }
            
            added[c - 'a'] = true;
            stack.push(c);    
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop()); //    //pop character from stack and build answer string from back

        }
        return sb.toString();
    }
}