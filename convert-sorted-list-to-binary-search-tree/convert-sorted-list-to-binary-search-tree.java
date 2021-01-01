 */
//Recursion
//TC: O(n logn)
//SC: O(n logn)
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)// If the head doesn't exist, then the linked list is empty
            return null;
        
        ListNode mid = middleElement(head);
        
        TreeNode node = new TreeNode(mid.val);// The mid becomes the root of the BST
        
        if(head == mid) // Base case when there is just one element in the linked list
            return node;
        
        // Recursively form balanced BSTs using the left and right halves of the original list.
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        
        return node;
    }
    
    private ListNode middleElement(ListNode head){
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
         // Handling the case when slowPtr was equal to head.
        if(prev != null)
