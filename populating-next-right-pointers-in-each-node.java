/*
class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        
        dfs(root, null);
        return root;
    }
    
    private void dfs(Node left, Node right){
        //base
        if(left == null)
            return;
        //logic
        left.next = right;
        dfs(left.left, left.right);
        
        if(right != null){
            dfs(left.right, right.left);
            dfs(right.left, right.right);
        }
    }
}
*/
​
​
class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);    //inserting root to queue
        while(!q.isEmpty()){
            int size = q.size();    //to process level by level
            for(int i=0; i<size; i++){
                Node curr = q.poll();   //get the topmost node from queue
                if(i != size-1){    //if its not last node
                    Node next = q.peek();   //get the next node
                    curr.next = next;
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
