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
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        
        while(!q.isEmpty()){
            int prevOdd = Integer.MAX_VALUE;
            int prevEven = Integer.MIN_VALUE;
            
            for(int i=q.size(); i>0; i--){
                TreeNode curr = q.poll();
                if(curr.val % 2 == level % 2)   //if level and current value are same either even or odd
                    return false;
                
                if(level % 2 == 1){ //if level is odd
                    if(prevOdd <= curr.val) //should be strictly increasing
                        return false;
                    prevOdd = curr.val; //udpate previous value
                }
                else{
                    if(prevEven >= curr.val)    //should be strictly decreasing
                        return false;
                    
                    prevEven = curr.val;    //udpate previous value
                }
                
                if(curr.left != null)
                    q.add(curr.left);
                
                if(curr.right != null)
                    q.add(curr.right);
            }
            level++;
        }
        return true;
    }
}