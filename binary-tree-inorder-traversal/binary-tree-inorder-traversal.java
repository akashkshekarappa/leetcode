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
//Iterative Method, stack
//TC:O(n)
//SC:O(n), and in the average case it's O(logn) where n is number of nodes.
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //TreeNode curr = root;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;   
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}

//Recursion
/*class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    private void helper(TreeNode root, List<Integer> result){
        if(root != null){
            if(root.left != null)
                helper(root.left, result);
            
            result.add(root.val);
            
            if(root.right != null)
                helper(root.right, result);
        }
    }
}*/
