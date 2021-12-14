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
//TC: O(n), worst case all nodes are within [L,R]
//SC: O(h), max call stack size is height of tree
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            
            if(curr != null){
                if(low <= curr.val && curr.val <= high)
                    sum += curr.val;
                
                if(low < curr.val)
                    stack.push(curr.left);
                
                if(high > curr.val)
                    stack.push(curr.right);
            }
        }
        return sum;
    }
}