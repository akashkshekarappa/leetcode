class Leaderboard {
​
    HashMap<Integer, Integer> map;
    public Leaderboard() {
        map = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId,0)+score);
    }
    
    public int top(int K) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue()); //max heap
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
            pq.add(entry);
        
        
        int result = 0;
        while(K > 0 && !pq.isEmpty()){
            Map.Entry<Integer,Integer> entry = pq.poll();
            result += entry.getValue();
            K--;
        }
        return result;
    }
    
    public void reset(int playerId) {
        map.put(playerId, 0);
    }
}
​
/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
