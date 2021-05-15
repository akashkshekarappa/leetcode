/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

///TC: O(n)
//SC: O(1)
class Solution {
    public Node inorderSuccessor(Node node) {
       // the successor is somewhere lower in the right subtree 
        if(node.right != null){
            node = node.right;
            while(node.left != null)
                node = node.left;
            
            return node;
        }
        // the successor is somewhere upper in the tree
        while(node.parent != null && node == node.parent.right)
            node = node.parent;
        
        return node.parent;
    }
}