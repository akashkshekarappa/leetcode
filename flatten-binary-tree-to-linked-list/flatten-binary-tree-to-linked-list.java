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
// O(1) Iterative Solution
// Time Complexity : O(n), number of nodes
// Space Complexity : O(1)
class Solution {
    public void flatten(TreeNode root) {
        //base case
		if(root == null)
			return;

        
		while(root != null){
			// If the node has a left child
            if(root.left != null){
                TreeNode rightMost = root.left;
                while(rightMost.right != null){
                    rightMost = rightMost.right;
                }
                
                //rewrite connections
                rightMost.right = root.right;
                root.right = root.left;
                root.left = null;
            }
             // move on to the right side of the tree
            root = root.right;
        }
	}
}