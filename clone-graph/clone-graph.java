/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
//DFS
//TC:O(N + M) , SC: O(N)
class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)    //base case
            return node;
        
        if(map.containsKey(node))   //If the node was already visited before, Return the clone from the visited dictionary.
            return map.get(node);
        
        Node cloneNode = new Node(node.val, new ArrayList<>());
        map.put(node, cloneNode);
        
        for(Node neighbor: node.neighbors)
            cloneNode.neighbors.add(cloneGraph(neighbor));
        
        return cloneNode;
    }
}