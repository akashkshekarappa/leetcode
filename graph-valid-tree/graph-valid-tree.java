//Iterative BFS
//TC: O(N)
//SC: O(N)
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1)
            return false;
        //building adjacency list for undirected graph
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i=0; i<n; i++){ 
            adjacencyList.add(new ArrayList<>());
        }
        for(int[] edge: edges){ //becuase undirected graph
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        seen.add(0);
        q.add(0);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neighbour: adjacencyList.get(curr)){
                if(seen.contains(neighbour))
                    continue;
                
                seen.add(neighbour);
                q.add(neighbour);
            }
        }
        return seen.size() == n;
    }
}