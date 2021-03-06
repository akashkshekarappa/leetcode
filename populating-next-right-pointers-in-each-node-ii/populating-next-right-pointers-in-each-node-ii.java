/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
//TC: O(n)
//SC: O(n)

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);    //inserting root to queue
        
        while(!q.isEmpty()){
            int size = q.size();    //to process level by level
            for(int i=0; i<size; i++){
                Node curr = q.poll();   //get the topmost node from queue
                if(i != size-1){    //if its not last node
                    curr.next = q.peek();;
                }
                
                //adding the left and right child of the node to queue
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
        return root;
    }
}