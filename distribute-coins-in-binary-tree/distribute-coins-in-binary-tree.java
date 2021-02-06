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
//DFS Approach
//TC: O(n)
//SC: O(h)
class Solution {
    int result;
    public int distributeCoins(TreeNode root) {
        if(root == null)//base case
            return 0;
        result = 0;
        dfs(root);
        return result;
    }
    private int dfs(TreeNode root){
        if(root == null)
            return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        result+= Math.abs(l) + Math.abs(r);
        
        return root.val + l + r -1;
    }
}