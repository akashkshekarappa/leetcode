class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];
        int result = 0;
        
        for(char c: chars.toCharArray())
            freq[c - 'a']++;
        
        for(String word: words){
            if(isValid(word, freq.clone()))
                result+= word.length();
        }
        return result;
    }
    
    private boolean isValid(String s, int[] freq){
        for(char c: s.toCharArray()){
            if(--freq[c - 'a'] < 0)
                return false;
        }
        return true;
    }
}