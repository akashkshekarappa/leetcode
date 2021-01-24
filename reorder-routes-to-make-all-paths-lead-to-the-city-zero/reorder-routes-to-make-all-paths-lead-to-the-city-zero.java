//DFS Approach
//TC: O(n)
//SC: O(n)
class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] connection = new List[n]; //ajdacency list where int[] will be [dest,cost]
        for(int[] con: connections){
            if(connection[con[0]] == null)
                connection[con[0]] = new ArrayList<>();
            if(connection[con[1]] == null)
                connection[con[1]] = new ArrayList<>();
            
            connection[con[0]].add(new int[] {con[1], 1});//original direction, costs 1
            connection[con[1]].add(new int[] {con[0], 0});//oposite directions, costs 0
        }
        return dfs(0, connection, new boolean[n]);
    }
    
    private int dfs(int curr, List<int[]>[] connection, boolean[] visited){
        int cost = 0;
        visited[curr] = true;
        for(int[] neighbour: connection[curr]){
            if(!visited[neighbour[0]]){
                cost+= neighbour[1];
                
                cost+= dfs(neighbour[0], connection, visited);
            }
        }
        return cost;
    }
}
​
/*
Transform each edge in a bi-directional edge, so that when you go on the right (original) direction, it costs you 1, and when you go on the not original direction, it costs you 0.
Start a dfs from city 0 and go to its neighbors, and always add the cost of going to that direction.
Because of what you did on (1), if the direction is correct, it means that that edge needs to be reversed, hence it will cost one
*/
