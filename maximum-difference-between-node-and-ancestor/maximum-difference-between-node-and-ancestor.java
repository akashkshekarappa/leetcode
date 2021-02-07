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
//TC: O(N)
//SC: O(N)
class Solution {
    int diff = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return diff;
    }
    private void dfs(TreeNode root, int min, int max){
        if(root != null){
            min = Math.min(min, root.val);
            max = Math.max(max, root.val);
            diff = Math.max(diff, max-min);
        }
        
        if(root.left != null)
            dfs(root.left, min, max);
        if(root.right != null)
            dfs(root.right, min, max);
    }
}