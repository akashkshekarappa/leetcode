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
class Solution {
    int count = 0;
    int k;
    HashMap<Integer, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0);
        return count;
    }
    private void preorder(TreeNode root, int currSum){
        if(root == null)
            return;
        // current prefix sum
        currSum += root.val;
        
        // here is the sum we're looking for
        if (currSum == k)
            count++;
        // number of times the curr_sum − k has occured already, 
        // determines the number of times a path with sum k 
        // has occured upto the current node
        count += map.getOrDefault(currSum - k, 0);
        
        
        // add the current sum into hashmap
        // to use it during the child nodes processing
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        // process left subtree
        preorder(root.left, currSum);
        // process right subtree
        preorder(root.right, currSum);
​
        // remove the current sum from the hashmap
        // in order not to use it during 
        // the parallel subtree processing
        map.put(currSum, map.get(currSum) - 1);
​
    }
}
