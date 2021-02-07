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
//Postorder Traversal
//TC: O(N)
//SC: O(N)
class Solution {
    class State{ // for each node in the tree, we will maintain three values
        int nodeCount; int totalSum; double maxAverage;
        State(int nodes, int sum, double maxAverage){
            this.nodeCount = nodes; this.totalSum = sum; this.maxAverage = maxAverage;
        }
    }
    public double maximumAverageSubtree(TreeNode root) {
        return maxAverage(root).maxAverage;
    }
    public State maxAverage(TreeNode root){
        if(root == null)
            return new State(0, 0, 0);
        // postorder traversal, solve for both child nodes first.
        State left = maxAverage(root.left);
        State right = maxAverage(root.right);
        
        // now find nodeCount, totalSm and maxAverage for current node `root`
        int nodeCount = left.nodeCount + right.nodeCount + 1;
        int sum = left.totalSum + right.totalSum + root.val;
        
        double maxAverage = Math.max((1.0*(sum))/nodeCount, Math.max(right.maxAverage, left.maxAverage));
        
        return new State(nodeCount, sum, maxAverage);
    }
}