//DP with memoization. DP does not neccessarily need to be iteration. It can be recursion as long as the results of subproblems are cached.
//TC:
//SC:
​
class Solution {
    HashMap<String, List<String>> map = new HashMap<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(map.containsKey(s))
            return map.get(s);
        
        List<String> result = new LinkedList<>();
        if(wordDict.contains(s))
            result.add(s);
        
        for(int i=1; i<s.length(); i++){
            String left = s.substring(0, i);
            String right = s.substring(i);
            
            if(wordDict.contains(left) && containSuffix(right, wordDict)){
                for(String str: wordBreak(right, wordDict))
                    result.add(left + " " + str);
            }
        }
        map.put(s, result);
        return result;
    }
    
    private boolean containSuffix(String s, List<String> wordDict){
        for(int i=0; i<s.length(); i++){
            if(wordDict.contains(s.substring(i)))
                return true;
        }
        return false;
    }
}
