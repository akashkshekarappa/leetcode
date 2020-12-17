class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(c == '#'){
                if(!s.isEmpty())
                    s.pop();
            }
            else
                s.push(c);            
        }
        for(int i=0; i<T.length(); i++){
            char c = T.charAt(i);
            if(c == '#'){
                if(!t.isEmpty())
                    t.pop();
            }
            else
                t.push(c); 
        }
        while(!s.isEmpty() && !t.isEmpty()){
            char c=s.pop();
            if(c!=t.pop())
                return false;
        }
        return s.isEmpty() && t.isEmpty();
    }
}
