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
//TC: O(n)
//SC: O(n)
class Solution {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root){
        if(root == null)
            return 0;
        int lengthOfLeft = dfs(root.left);
        int lengthOfRight = dfs(root.right);
        max = Math.max(max,lengthOfLeft + lengthOfRight);
        return Math.max(lengthOfLeft, lengthOfRight) +1;
    }
}