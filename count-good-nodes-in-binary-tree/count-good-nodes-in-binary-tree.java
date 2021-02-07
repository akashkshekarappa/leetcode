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
//DFS Approach
//TC: O(N)
//SC: O(N)
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    private int dfs(TreeNode root, int max){
        if(root == null)//base case
            return 0;
        int count = 0;
        
        if(root.val >= max){
            max = root.val;
            count++;
        }    
        return count+= dfs(root.left, max) + dfs(root.right, max);
    }
}