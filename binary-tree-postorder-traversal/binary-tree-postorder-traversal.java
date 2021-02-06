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
//Iterativr Approach
//TC: O(n)
//SC: O(n)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        if(root == null)
            return result;
        
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            result.add(0, root.val);
            
            if(root.left != null)
                st.add(root.left);
            if(root.right != null)
                st.add(root.right);
        }
        return result;
    }
}