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
//BFS
//TC: O(N)
//SC: O(N)
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        root.val = 0;
        int max = 1;
        
        while(!q.isEmpty()){
            int size = q.size();
            max = Math.max(max, q.peekLast().val - q.peekFirst().val + 1);
            
            for(int i=0; i<size; i++){
                root = q.poll();
                
                if(root.left != null){
                    root.left.val = root.val * 2;
                    q.add(root.left);
                }
                
                if(root.right != null){
                    root.right.val = root.val * 2 + 1;
                    q.add(root.right);
                }
            }
        }
        return max;
    }
}