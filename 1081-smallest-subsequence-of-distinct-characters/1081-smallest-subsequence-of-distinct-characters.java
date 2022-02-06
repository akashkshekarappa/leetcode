class Solution {
    public String smallestSubsequence(String s) {
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