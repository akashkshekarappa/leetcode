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
//BFS
//TC: O(n)
//SC: O(n)
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null || root.right==null || root.left==null) 
            return -1;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        Integer secondMin = null;
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.right!=null) 
                q.add(curr.right);
            if(curr.left!=null) 
                q.add(curr.left);
​
            if(curr.val!=root.val) {
                if(secondMin==null) 
                    secondMin = curr.val;
            else 
                secondMin = Math.min(secondMin, curr.val);
        }
    }
    return secondMin==null? -1 : secondMin;
    }
}
