class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int slow = 0; // sliding window slow and fast pointers
        int fast = 0;
        int max = 1;
        
        if(s.length() * k == 0)
            return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(fast < s.length()){
            char c = s.charAt(fast);
            map.put(c, fast);   // storing character and its index, // when the slidewindow contains less than 3 characters
            fast++;
            
            if(map.size() == k + 1){
                int delIndex = Collections.min(map.values());     // delete the leftmost character
                map.remove(s.charAt(delIndex));
                
                slow = delIndex+1; // move left pointer of the slidewindow
            }
           
            max = Math.max(max, fast-slow);    // find max distance as max of previous max and distance between slow and fast
            
        }
        return max;
    }
}
