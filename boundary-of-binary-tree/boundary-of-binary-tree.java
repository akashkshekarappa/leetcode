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
//TC: O(n)
//SC: O(n)
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null)    //base case
            return result;
        
        result.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return result;
    }
    private void leftBoundary(TreeNode root){
        if(root == null || (root.left == null && root.right == null))//base case
            return;
        result.add(root.val);
        if(root.left == null)
            leftBoundary(root.right);
        else
            leftBoundary(root.left);
    }
    
    private void rightBoundary(TreeNode root){
        if(root == null || (root.right == null && root.left == null))//base case
            return;
        if(root.right == null)
            rightBoundary(root.left);
        else
            rightBoundary(root.right);
        result.add(root.val);    // add after child visit(reverse)
    }
    
    private void leaves(TreeNode root){
        if(root == null)//base case
            return ;
        if(root.left == null && root.right == null){
            result.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
}
