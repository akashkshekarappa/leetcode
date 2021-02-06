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
//Recursion + HashMap
//TC: O(N)
//SC: O(N)
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>(); // to store inorder values and their index
	int postOrderIndex;	//index location of the post order array
    public TreeNode buildTree(int[] inorder, int[] postorder) {
          postOrderIndex = postorder.length-1;	// In postorder, root will be at end,hence index=length-1
        
		for(int i=0; i<inorder.length; i++)
			map.put(inorder[i], i);	// adding values to the hashmap

		return helper(inorder, postorder, 0, inorder.length-1);

	}

	private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
		if(start > end || postOrderIndex < 0)		// base condition
			return null;

        //logic
        TreeNode root = new TreeNode(postorder[postOrderIndex]);	// using postorder we create the root starting at end of array
        postOrderIndex--;	// next value will give right values and then left
        
        int index = map.get(root.val);	// getting the index of root in inorder
        
        root.right = helper(inorder, postorder, index+1, end);	//creating the right subtree of node first as the next value we get in postorder is the right subtree
		root.left = helper(inorder, postorder, start, index-1);	//creating the left subtree of node

		return root;
    }
}