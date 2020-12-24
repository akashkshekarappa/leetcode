class Solution {
    public List<String> topKFrequent(String[] words, int k) { 
        //map with key as nums and value as theircount
        HashMap<String, Integer> map = new HashMap<>();
        for(String w: words){
            map.put(w, map.getOrDefault(w, 0)+1);
        }
            
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) ->
        (map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b)));
        
        for(String w: map.keySet()){
            pq.add(w);
            
            if(pq.size() > k)
                pq.poll();
        }
        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(0, pq.poll());
        }    
        return result;
    }
}
