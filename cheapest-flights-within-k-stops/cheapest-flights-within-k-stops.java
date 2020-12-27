class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] flight: flights){
            
            if(!map.containsKey(flight[0]))
                map.put(flight[0], new HashMap<>());
            
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[] {0, src, K+1});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int price = curr[0];
            int city = curr[1];
            int stops = curr[2];
            
            if(city == dst)
                return price;
            
            if(stops > 0){
                Map<Integer, Integer> adj = map.getOrDefault(city, new HashMap<>());
                for(int ad: adj.keySet()){
                    pq.add(new int[] {price + adj.get(ad), ad, stops -1});
                }
            }
        }
        return -1;
    }
}
