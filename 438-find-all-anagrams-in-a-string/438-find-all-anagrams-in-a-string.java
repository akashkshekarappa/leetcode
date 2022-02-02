class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        
        int slow = 0;
        int fast = 0;
        int match = 0;
        
        while(fast < s.length()){
            char in = s.charAt(fast);
            if(map.containsKey(in)){
                int count = map.get(in);
                count--;
                map.put(in, count);
                
                if(count == 0)
                    match++;
            }
            
            if(fast >= p.length()){
                char out = s.charAt(slow);
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    map.put(out, count);
                    
                    if(count == 1)
                        match--;
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