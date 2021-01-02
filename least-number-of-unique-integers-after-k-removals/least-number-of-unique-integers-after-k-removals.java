class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if(arr == null || arr.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        
        for(int key: map.keySet()){
            pq.add(key);
        }
        
        while(k >0 && !pq.isEmpty())
            k -= map.get(pq.poll());
        
        if(k < 0)
            return pq.size() +1;
        
        return pq.size();
    }
}
