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
//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }
    public int[] helper(TreeNode root){
        if(root == null)    // return [rob this node, not rob this node]
            return new int[] {0, 0};
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        // if we rob this node, we cannot rob its children
        int rob = root.val + left[1] + right[1];
        
        // else, we free to choose rob its children or not
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[] {rob, notRob};
    }
}