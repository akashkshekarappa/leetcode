//TC: O(4n)
//S: O(nn)
​
class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexToRemove = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }
            
            if(s.charAt(i) == ')'){
                if(st.isEmpty()){
                    indexToRemove.add(i);
                }
                else
                    st.pop();
            }
        }
        
         // Put any indexes remaining on stack into the set.
        while(!st.isEmpty()){
            indexToRemove.add(st.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(!indexToRemove.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
