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

// LCA Approach
//TC: O(N)
//SC: O(N)
class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = LCA(root, p, q);
        return distance(lca, p, 0) + distance(lca, q, 0);
    }
    private TreeNode LCA(TreeNode root, int p, int q){
        if(root == null)
            return null;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if(root.val == p || root.val == q || (left != null && right != null))
            return root;
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }
    private int distance(TreeNode root, int target, int travel){
        if(root == null)
            return -1;
        if(root.val == target)
            return travel;
        
        int travelLeft = distance(root.left, target, travel +1);
        if(travelLeft == -1)
            return distance(root.right, target, travel+1);
        
        return travelLeft;
    }
}