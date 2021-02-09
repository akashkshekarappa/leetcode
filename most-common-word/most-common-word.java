//TC: O(N + M)
//SC: O(N + M)
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        //replace the punctuations with spaces and put all letters in lower case
        String normalizeString = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        //split the normalizeString into words
        String[] words = normalizeString.split("\\s+");
        
        Set<String> set = new HashSet<>();
        for(String word: banned){
            set.add(word);
        }
        
        Map<String, Integer> map = new HashMap<>();
         //count the appearance of each word, excluding the banned words
        for(String word: words){
            if(!set.contains(word)){
                map.put(word, map.getOrDefault(word, 0) +1);
            }
        }
        //return the word with the highest frequency
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}