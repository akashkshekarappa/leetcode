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

//DFS
//TC: O(n)
//SC: O(n)
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, root.left) + dfs(root, root.right);
    }
    private int dfs(TreeNode grand, TreeNode node){
        if(node == null)
            return 0;
        
        int sum = 0;
        
        if(grand.val % 2 == 0){
            sum += node.left == null ? 0 : node.left.val;
            sum += node.right == null ? 0 : node.right.val;
        }
        
        int leftSum = dfs(node, node.left);
        int rightSum = dfs(node, node.right);
        return sum + leftSum + rightSum;
    }
}