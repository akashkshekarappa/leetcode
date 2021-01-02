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
// Time Complexity :O(n), we traverse the entire input tree once
// Space Complexity : O(h), height of the tree
​
/* The Two trees are a mirror reflection of each other if: 
 * Their two roots have the same value and
 * The right subtree of each tree is a mirror reflection of the left subtree of the other tree.*/
​
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null)// when both left and right tree has reached null
            return true;
        if(t1 == null || t2 == null)// if the value of left and right tree are not equal or we have reached end of one of the tree
            return false;
        // returns true if two roots have the same value and the right subtree of each tree is a 
        //mirror reflection of the left subtree of the other tree
        return t1.val == t2.val && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }
}
