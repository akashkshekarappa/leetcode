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
//SC: O(n) in worst case, O(log n) is best case when its balanced tree
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)// p and q are both null
            return true;
        if(p == null || q == null)// one of p and q is null
            return false;
        if(p.val != q.val)  //if values or not equal
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}