/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//TC: O(n) 
//SC: O(h)
//inorder traversal(left, root, right)
class Solution {
    TreeNode prev = null;
    TreeNode head = null;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null)    //base case
            return null;
        
        increasingBST(root.left);
        
        if(prev != null){
            root.left = null;// we no  longer needs the left  side of the node, so set it to null
            prev.right = root;
        }
        
        if(head == null)// record the most left node as it will be our root
            head = root;
        
        prev = root;
        
        increasingBST(root.right);
        
        return head;
        
    }
}
