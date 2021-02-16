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

//Recursion
//TC: O(n)
//SC: O(h)
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root: null;
    }
    private boolean containsOne(TreeNode root){
        if(root == null)
            return false;
        boolean l = containsOne(root.left);
        boolean r = containsOne(root.right);
        if(!l)
            root.left = null;
        if(!r)
            root.right = null;
        return root.val == 1 || l || r;
    }
}