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
//TC: O(N)
//SC: O(N)
class Solution {
    int preOrderIndex = 0;
    int postOrderIndex = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preOrderIndex++]);
        if(root.val != post[postOrderIndex])
            root.left = constructFromPrePost(pre, post);
        if(root.val != post[postOrderIndex])
            root.right = constructFromPrePost(pre, post);
        postOrderIndex++;
        
        return root;
    }
}