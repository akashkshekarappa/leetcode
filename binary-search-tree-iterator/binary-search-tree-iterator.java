/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/* Push all the left nodes to the stack starting from the root in the constructor. 
 * This will push the nodes in descending order.
 * In the hasNext() return true if the stack has elements and false if its empty
 * In the next(), pop the node from the stack, push to the stack the right subtree of this node and return its value.*/
// Time Complexity : O(h)
// Space Complexity : O(h)
class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();  //global stack
    public BSTIterator(TreeNode root) {
        dfs(root);  // calling constructor on root
    }
    
    /** @return the next smallest number */
    public int next() {
        // when next is called, element on top gets popped, value to be returned
		TreeNode root = stack.pop();
        dfs(root.right);
        return root.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    private void dfs(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */