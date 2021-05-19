/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

//same as intersection of two linked list
//Get depth of each nodes.
//Level the nodes such that they are equal depth.
//In a loop visit their parents while they are not pointing to the same node
//TC: O(h), depth of tree
//SC: O(1)
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        if(p == null || q == null)
            return null;
        int pDepth = getDepth(p);
        int qDepth = getDepth(q);
        
        while(pDepth > qDepth){
            pDepth--;
            p = p.parent;
        }
        
        while(qDepth > pDepth){
            qDepth--;
            q = q.parent;
        }
        
        while(p != q){
            p = p.parent;
            q = q.parent;
        }
        return p;
    }
    
    private int getDepth(Node node){
        int depth = 0;
        while(node != null){
            node = node.parent;
            depth++;
        }
        return depth;
    }
}