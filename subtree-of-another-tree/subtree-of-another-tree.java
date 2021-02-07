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

//Recursive Approach, by comparison of nodes
//TC:O(m * n), In worst case(skewed tree) traverse function takes O(m*n)time.
//SC:O(n),The depth of the recursion tree can go upto n,n refers to the no of nodes in s
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
      if(s == null)
          return false;
        if(isSame(s, t))
            return true;
        //if tree t has exactly the same structure and node values with a subtree of s in left or right
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSame(TreeNode s, TreeNode t){
        //base condition, if both trees are null, then return true, else false
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        //logic
        
        if(s.val != t.val)
            return false;
        
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}