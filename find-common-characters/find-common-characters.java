//TC: O(mn)
//SC: O(1)
class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        
        for(char c='a'; c<='z'; c++){
            int mincount = Integer.MAX_VALUE;
            for(String s: A){
                int wordCount = 0;
                for(char curr: s.toCharArray())
                    if(curr == c)
                        wordCount++;
                
                mincount = Math.min(mincount, wordCount);
            }
            
            for(int i=0; i<mincount; i++)
                result.add("" + c);
        }
        return result;
    }
}