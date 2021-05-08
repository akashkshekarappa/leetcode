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
//TC: O(n)
//SC: O(n) worst case, best case when tree is balanced O(logn)
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)    //base case
            return 0;
        
        int leftHeight = maxDepth(root.left);   //recursively call on left and right child of root
        int rightHeight = maxDepth(root.right);
        
        return Math.max(leftHeight, rightHeight) +1;
    }
}