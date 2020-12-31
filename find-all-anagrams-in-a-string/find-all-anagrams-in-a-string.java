class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();  //freq of each character of string p
        int match = 0;
        for(int i=0; i<p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) +1);    //adding frequeny for each character
        }
        int slow = 0, fast = 0;
        
        while(fast < s.length()){
            char in = s.charAt(fast);
            if(map.containsKey(in)){
                int count = map.get(in);    
                count --;    //reduce the count, if character found
                map.put(in, count);     //updating the count
​
                if(count == 0)  //when count becomes zero, thers match
                    match++;
            }
            
            if(fast >= p.length()){
                char out = s.charAt(slow);
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;    // increasing count for outgoing character
                    map.put(out, count);
​
                    if(count == 1)
                        match--;    //if counts is 1, then decrease match
                }
                slow++;
            }
            if(match == map.size())
                result.add(slow);
            
            fast++;
        }
        return result;
    }
}
