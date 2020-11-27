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
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        helper(root, 0);    // calling recursive preorder method with sum 0
        return result;
    }
    private void helper(TreeNode root, int currentSum){
        if(root == null)    // base case, when we reach a point where there is one child and other is null
            return;
​
        currentSum = currentSum * 10 + root.val;
​
        if(root.left == null && root.right == null)
            result += currentSum;   // calculate sum for the leaf and return sum
​
        helper(root.left, currentSum);   // calling for left subtree with sum
        helper(root.right, currentSum); // calling for right subtree with sum
    }
}
