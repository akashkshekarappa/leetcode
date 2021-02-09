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
//TC: O(n)
//SC: O(n)
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }
    private boolean helper(TreeNode root, int k, Set<Integer> set){
        //base case
        if(root == null)
            return false;
        //logic
        if(set.contains(k - root.val))
            return true;
        set.add(root.val);
        return helper(root.left, k, set) || helper(root.right, k , set);
    }
}