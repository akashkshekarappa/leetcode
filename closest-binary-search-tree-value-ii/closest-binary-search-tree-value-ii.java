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
//Recursive Inorder + Heap
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> nums = new ArrayList<>();
        // init heap 'less close element first'
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> 
                                                             Math.abs(a - target) > Math.abs(b- target) ? -1 : 1);
        inorder(root, nums, minHeap, k);
        
        return new ArrayList<>(minHeap);
    }
    
    private void inorder(TreeNode root, List<Integer> nums, Queue<Integer> heap, int k){
        if(root == null)
            return;
        
        inorder(root.left, nums, heap, k);
        
        heap.add(root.val);
        if(heap.size() > k)
            heap.poll();
        
        inorder(root.right, nums, heap, k);
    }
}
