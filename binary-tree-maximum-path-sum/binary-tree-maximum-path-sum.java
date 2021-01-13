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
//Recursion
//TC: O(n)
//SC: O(h)
class Solution {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        //base case
        if(root == null)
            return 0;
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }
    private int maxGain(TreeNode root){
        if(root == null)
            return 0;
        
        // max sum on the left and right sub-trees of node
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        
        // the price to start a new path where `node` is a highest node
        int priceNewPath = root.val + leftGain + rightGain;
        // update max_sum if it's better to start a new path
        maxSum = Math.max(maxSum, priceNewPath);
        
    // for recursion, return the max gain if continue the same path
        return root.val + Math.max(leftGain, rightGain);
    }
}
