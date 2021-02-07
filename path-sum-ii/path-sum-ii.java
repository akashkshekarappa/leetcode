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
// Time Complexity: O(n^2), we create copy of elements each time
// Space Complexity : O(n^2) copy of elements each time
class Solution {
    List<List<Integer>> result;//global result so that we dont have to pass again and again
	int target;	// global variable target sum
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        target = sum;
        if(root == null)
            return result;
        
        dfs(root, 0, new ArrayList<>());// calling dfs for sum 0 and path pointing to empty list

		return result;
    }
    private void dfs(TreeNode root, int currSum, List<Integer> temp){
        if(root == null)//edge case, when we reach the null node
            return;
        //logic
        currSum += root.val;	// finding sum for the node for which the call is made using prev sum
		temp.add(root.val);	// adding node to path
        
        if(root.left == null && root.right == null){
            if(target == currSum)
                result.add(new ArrayList<>(temp));
        }
        dfs(root.left, currSum, new ArrayList<>(temp));	// calling on left subtree by creating a copy of the path and passing its pointer as the original path is getting changed
		dfs(root.right, currSum, new ArrayList<>(temp));	// calling on right subtree
	
    }
}