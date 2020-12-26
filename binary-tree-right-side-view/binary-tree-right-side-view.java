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
//Using BFS
//Time Complexity : O(n), n is the number of nodes in the tree.
//Space Complexity : O(n) , the max number of elements possible in queue are leaf nodes (i.e n/2)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
​
        Queue<TreeNode> q = new LinkedList<>(); // queue to process all nodes with processing all children at one go
​
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();    // size of the number of elements in queue currently (at the level)
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();    // removing front element from queue
​
                if(i == size-1){    // last node of the level   // if (i == 0), taking the very first node will be left side view
                    result.add(curr.val);
                }
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
        return result;
    }
}
