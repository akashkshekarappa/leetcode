/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
​
//TC: O(n)
//SC: O(n)
class Solution {
    List<TreeNode> sortedArray = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorderTraverse(root);
        return sortedArrayToBST(0, sortedArray.size()-1);
    }
    
    private void inorderTraverse(TreeNode root){
        if(root == null)
            return;
        
        inorderTraverse(root.left);
        sortedArray.add(root);
        inorderTraverse(root.right);
    }
    
    private TreeNode sortedArrayToBST(int start, int end){
        if(start > end)
            return null;
        int mid = start + (end-start)/2;
        
        TreeNode root = sortedArray.get(mid);
        root.left = sortedArrayToBST(start, mid-1);
        root.right = sortedArrayToBST(mid+1, end);
        
        return root;
            
    } 
}
