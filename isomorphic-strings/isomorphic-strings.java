//TC: O(n)
//SC: O(n)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        HashMap<Character, Character> map1 = new HashMap<>(52);
        for(int i=0; i<s.length(); i++){
            if(map1.get(s.charAt(i)) != null){
                if(map1.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            else 
                map1.put(s.charAt(i), t.charAt(i));
        }
        
        HashMap<Character, Character> map2 = new HashMap<>(52);
        for(int i=0; i<t.length(); i++){
            if(map2.get(t.charAt(i)) != null){
                if(map2.get(t.charAt(i)) != s.charAt(i))
                    return false;
            }
            else
                map2.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
}