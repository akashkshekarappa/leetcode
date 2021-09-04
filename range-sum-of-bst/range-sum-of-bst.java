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
    int sum;
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            
            if(curr != null){
                if(L <= curr.val && curr.val <= R)
                    sum+= curr.val;
                
                if(L < curr.val)
                    st.push(curr.left);
                
                if(curr.val < R)
                    st.push(curr.right);
            }
        }
        return sum;
    }
}