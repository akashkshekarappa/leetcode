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
//TC: O(n)
//SC: O(n)
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            long sum = 0;
            long count = 0;
            Queue<TreeNode> temp = new LinkedList<>();
            while(!q.isEmpty()){
                TreeNode curr = q.poll();
                sum+= curr.val;
                count++;
                
                if(curr.left != null)
                    temp.add(curr.left);
                if(curr.right != null)
                    temp.add(curr.right);
            }
            q = temp;
            result.add(sum * 1.0 / count);
        }
        return result;
    }
}