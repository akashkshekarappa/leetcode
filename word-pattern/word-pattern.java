class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        
        String[] words = str.split(" ");
        
        if(pattern.length() != words.length)
            return false;
        
        for(int i =0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            String w = words[i];
            
            if(!map1.containsKey(c)){
                if(map2.containsKey(w)){
                    return false;
                }
                else{
                    map1.put(c, w);
                    map2.put(w, c);
                }
            }
            else{
                String mappedWord = map1.get(c);
                if(!mappedWord.equals(w))
                    return false;
            }
        }
        return true;
    }
}