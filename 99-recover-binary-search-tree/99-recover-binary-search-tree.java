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
// Time Complexity : O(n), number of nodes
// Space Complexity :O(h), recusive stack space
/**By doing inorder traversal, pair of breaches can be identified
 * where the ascending order is changed, is the point of breach.
 * The nodes at which breaches are occurred are identified and are replaced ***/

class Solution {
    TreeNode first;	//pointing to first element of breach
	TreeNode last;	//pointing to last element of breach
	TreeNode prev;	//to keep track of prev element
	boolean flag;	//to check if it is first breach or second
	public void recoverTree(TreeNode root) {    
		if(root == null)
			return;

		inorder(root);      
		//swapping
		int temp = first.val;
		first.val = last.val;
		last.val = temp;
	}

	private void inorder(TreeNode root){
		//base
		if(root == null)
			return;
		//logic
		inorder(root.left);
		//root = st.pop() happens here
		if(prev != null && prev.val >= root.val){   //there is a breach, if prev is there and prev value is greater than root which is invalid in inorder
			if(!flag){  //first pair of breach
				first = prev;
				last = root;
				flag = true;
			}
			else{	// second breach
				last = root;
			}
		}
		prev = root;	// setting prev as root each time
		inorder(root.right);
	}
}