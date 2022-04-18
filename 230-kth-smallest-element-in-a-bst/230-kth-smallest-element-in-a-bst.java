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

//Time Complexity : O(k)
//Space Complexity : O(h), if its balanced BST: O(log n)

/**since, its a BST, Inorder traversal of BST will be sorted
 * will do inorder traversal and return the kth element that is popped.**/
class Solution {
    public int kthSmallest(TreeNode root, int k) {        
		Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        k--;
        if(k == 0)
            return root.val;
        
        root = root.right;
        }
        return -1;
    }
}