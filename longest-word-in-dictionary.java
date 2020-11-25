//TC: O(w^2), W is length of words[i]
class Solution {
    public String longestWord(String[] words) {
        String result = "";
        Set<String> set = new HashSet<>();
        for(String word: words){
            set.add(word);
        }
        
        for(String word: words){
            if(word.length() > result.length() || word.length() == result.length() && word.compareTo(result) < 0){
                boolean good = true;
                
                for(int k=1; k<word.length(); k++){
                    if(!set.contains(word.substring(0, k))){
                        good = false;
                        break;
                    }
                }
                if(good)
                    result = word;
            }
        }
        return result;
    }
}
