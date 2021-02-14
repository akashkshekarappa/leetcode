//TC: O(C)
//SC O(1)
class Solution {
    HashMap<Character, Integer> map;
    public boolean isAlienSorted(String[] words, String order) {
        map = new HashMap<>();
        for(int i=0; i<order.length(); i++){
            char c = order.charAt(i);
            map.put(c, i+1);
        }
        for(int i=0; i<words.length -1; i++){
            if(compare(words[i] , words[i+1]))
                return false;
        }
        return true;
    }
    private boolean compare (String s1, String s2){
        for(int i=0; i<s1.length() && i<s2.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                return map.get(s1.charAt(i)) > map.get(s2.charAt(i));
        }
        return s1.length() > s2.length();
    }
}