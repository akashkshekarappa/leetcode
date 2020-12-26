//
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int slow = 0; // sliding window slow and fast pointers
        int fast = 0;
        int max = 2;
        
        if(s.length() < 3)
            return s.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(fast < s.length()){
            char c = s.charAt(fast);
            map.put(c, fast);   // storing character and its index, // when the slidewindow contains less than 3 characters
            fast++;
            
            if(map.size() == 3){
                int delIndex = Collections.min(map.values());     // delete the leftmost character
                map.remove(s.charAt(delIndex));
                
                slow = delIndex+1; // move left pointer of the slidewindow
            }
           
            max = Math.max(max, fast-slow);    // find max distance as max of previous max and distance between slow and fast
            
        }
        return max;
    }
}
