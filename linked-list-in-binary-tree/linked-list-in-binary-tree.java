/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
//Recursive approach
//TC: O(N)
//SC: O(N)
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean ans = check(head, root);//Check if a downward path is found starting from the root node
        
        if(root != null && !ans){//If path is not found, check in the left and right subtrees
            ans |= isSubPath(head, root.left);
            ans |= isSubPath(head, root.right);
        }
        return ans;
    }
    private boolean check(ListNode head, TreeNode root){
        if(head == null)//If the ListNode is null, we've reached the end of the list where all values match the ones in the tree. This means we've found a path. 
            return true;
        if(root == null)//If the TreeNode is null, but the ListNode is not, we've reached the end of the subtree but not the list, so, return False.
            return false;
        //If the value of the current node matches the next node of the list, try to find a path in the left or right subtree, otherwise return False
        if(root.val == head.val)
            return check(head.next, root.left) || check(head.next, root.right);
        
        return false;
    }
}