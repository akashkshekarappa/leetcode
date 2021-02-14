//TC: O(V + E)
//SC: O(V)
class Solution {
    int time = 0;
    List<List<Integer>> result;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        buildGraph(map, connections, n);
        
        int[] discovery = new int[n];//each index in discover[] tracks the order of flow of dfs to reach node i
        Arrays.fill(discovery, -1);//initially fill discovery[] with -1s since no node is visited
        int[] lowest = new int[n];//lowest[i] tracks the earliest discovered node that can be reached from i
        
        result = new ArrayList<>();
        dfs(map, 0, 0, discovery, lowest);//start from 0th node - parent of this is itself
        
        return result;
    }
    
    private void buildGraph(HashMap<Integer, List<Integer>> map, List<List<Integer>> connections, int noOfNodes){
        for(int i=0; i<noOfNodes; i++){
            map.put(i, new ArrayList<>());//creating an empty array list to each node and inserting it to map
        }
        for(List<Integer> edge : connections){
            int from = edge.get(0); int to = edge.get(1);
            map.get(from).add(to);//add to to neighber list of from
            map.get(to).add(from);//add from to neighbor list of to
        }
        return;
    }
    
    private void dfs(HashMap<Integer, List<Integer>> map, int current, int parent, int[] discovery, int[] lowest){
        //base case
        if(discovery[current] != -1)
            return;
        //logic
        discovery[current] = time;//setting time and marking current as visited
        lowest[current] = time;
        time++;
        //recurse on neighbors
        for(Integer neighbor: map.get(current)){
            if(neighbor == parent)//dont recurse if neighbor is parrent of current
                continue;
            
            dfs(map, neighbor, current, discovery, lowest);
            if(lowest[neighbor] > discovery[current])//add edge to result conditionally
                result.add(Arrays.asList(current, neighbor));
            
            lowest[current] = Math.min(lowest[current], lowest[neighbor]);   //update lowest of current   
        }
        return;
    }
}