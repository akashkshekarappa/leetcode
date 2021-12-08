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
//Approach : Post order DFS traversal
class Solution {
    private int totalTilt = 0;
    public int findTilt(TreeNode root) {
        totalTilt = 0;
        valueSum(root);
        
        return totalTilt;
    }
    
    private int valueSum(TreeNode root){
        if(root == null)
            return 0;
        
        int leftSum = valueSum(root.left);
        int rightSum = valueSum(root.right);
        
        int tilt = Math.abs(leftSum - rightSum);
        
        totalTilt += tilt;
        
        // return the sum of values starting from this node.
        return root.val + leftSum + rightSum;
    }
}