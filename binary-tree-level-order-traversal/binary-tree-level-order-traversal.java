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
//Using BFS
//Time Complexity :O(n), n is the number of nodes in the tree.
//Space Complexity : O(n) , the max number of elements possible in queue are leaf nodes (i.e n/2)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

		if(root == null)
			return result;

		// to process the nodes in FIFO manner, queue is used
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()){
			List<Integer> list = new ArrayList<>(); // inner list, creates a list at each level
			int size = queue.size();    // to calculate the size of the queue at current level

			for(int i=0; i<size; i++){  // processing elements of current level
				TreeNode curr = queue.poll();   // to return the front element out of the queue
				list.add(curr.val);

				if(curr.left != null)
					queue.add(curr.left);

				if(curr.right != null)
					queue.add(curr.right);
			}
			result.add(list);   // add the resultant list to final result list
		}
		return result;   
    }
}