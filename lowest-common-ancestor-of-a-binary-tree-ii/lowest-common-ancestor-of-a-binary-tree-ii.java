/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Recursion
//TC: O(n)
//SC: O(n)
class Solution {
    int count = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = dfs(root, p, q);
        return count == 2 ? result : null;
    }
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return root;
        
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        
        if(root == p || root == q){
            count++;
            return root;
        }
        
        if(left != null && right != null)
            return root;
        
        return (left != null) ? left : right;
    }
}