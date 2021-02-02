class Solution {
    public String reorganizeString(String S) {
        if(S == null || S.length() == 0)    //base case
            return "";
        Map<Character, Integer> map = new HashMap<>();  //to count how many times each char occured
        for(char c: S.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        
        PriorityQueue<Character> maxHeap = new PriorityQueue((a, b) -> map.get(b) - map.get(a));    //max heap to get how many character each occured
        maxHeap.addAll(map.keySet());   //addAll because add more elements
        
        StringBuilder result = new StringBuilder();
        while(maxHeap.size() >1){
            char curr = maxHeap.poll(); //add most frequently occuring and next most to result (sb)
            char next = maxHeap.poll();
            result.append(curr);
            result.append(next);
            
            map.put(curr, map.get(curr)-1);
            map.put(next, map.get(next)-1);
            
            if(map.get(curr) > 0)
                maxHeap.add(curr);
            if(map.get(next) > 0)
                maxHeap.add(next);
        }
        
        
        if(!maxHeap.isEmpty()){
            char last = maxHeap.poll();
            if(map.get(last) > 1)
                return "";//if one char is left in heap, then return empty
            
            result.append(last);
        }
        return result.toString();
    }
}