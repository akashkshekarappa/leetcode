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
//Approcah: If root is null - return TreeNode(val).If val > root.val - go to insert into the right subtree.If val < root.val - go to insert into the left subtree.Return root
//TC: O(n)- worstcase.,  Avg:  O(logn)
//SC O(H)
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        
        if(val > root.val)
            root.right = insertIntoBST(root.right, val);
        else 
            root.left = insertIntoBST(root.left, val);
        
        return root;
    }
}
