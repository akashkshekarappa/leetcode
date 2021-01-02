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
​
//TC: O(n)
//SC: O(log n)
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        
        sum = sum - root.val;
        if(root.left == null && root.right == null)
            return sum == 0;
        
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
