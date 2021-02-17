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
//Time Complexity : O(n)
//Space Complexity : O(1)

/* Using two pointers slow and fast, Slow pointer that points to the first node and doesn't move until we reach the node n and put a fast pointer there 
 * move slow and fast pointer until fast is at the last element. 
 * The next node after slow is the one we want to remove. Point its next to next next.*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int count = 0;
        
        while(count <= n){
            fast = fast.next;
            count++;
        }
        
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}