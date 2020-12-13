//BFS
//TC: O(V + E)
//SC: O(V)
class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        
        for(int i=0; i<len; i++){
            if(colors[i] != 0)
                continue;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            colors[i] = 1;  //blue = 1, red = -1
            
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int next: graph[curr]){
                    if(colors[next] == 0){// If this node hasn't been colored;
                        colors[next] = -colors[curr];// Color it with a different color;
                        q.add(next);
                    }
                    else if(colors[next] != -colors[curr])
                        return false;
                }
            }
        }
        return true;
    }
}
