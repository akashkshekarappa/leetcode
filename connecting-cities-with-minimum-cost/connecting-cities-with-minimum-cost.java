class Solution {
    public int minimumCost(int N, int[][] connections) {
        int[] map = new int[N];
        for(int i = 0; i < N; i++){
            map[i] = i;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2){
                return Integer.compare(a1[2], a2[2]);
            }
        });
        
        for(int[] i: connections){
            pq.offer(i);
        }
        int cost = 0;
        int edge = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int l = find(map, cur[0]-1);
            int r = find(map, cur[1]-1);
            if(l != r){
                cost += cur[2];
                map[l] = r;
                edge++;
                if(edge == N-1) return cost;
            }
        }
        return -1;
    }
    
    public int find(int[] map, int id){
        while(map[id] != id){
            map[id] = map[map[id]];
            id = map[id];
        }
        return id;
    }
}