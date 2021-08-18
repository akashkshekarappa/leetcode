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
//Time Complexity : O(n), n is the number of nodes in the tree.
//Space Complexity : O(n) , the max number of elements possible in queue are leaf nodes (i.e n/2)
class Solution {
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null)
            return result;
       
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max;
        while(!q.isEmpty()){
            int size = q.size();
            max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                max = Math.max(curr.val, max);
                
                if(curr.left != null)
                    q.add(curr.left);
                
                if(curr.right != null)
                    q.add(curr.right);
            }
            result.add(max);
        }
        return result;
    }
}