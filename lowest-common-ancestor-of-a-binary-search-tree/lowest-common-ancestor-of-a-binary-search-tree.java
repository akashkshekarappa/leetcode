/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**Since its BST
 * If both p and q values are less than root.val, then go to root.left
 * if both p and q values are greater than root.val, then go to root.right
 * else just return root*/
//TC: O(n)
//SC: O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(p.val < root.val && q.val < root.val)
            root = root.left;
        else if(p.val > root.val && q.val > root.val)
            root = root.right;
        else
            return root;
        }
        return null;
    }
}
