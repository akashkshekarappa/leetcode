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

//TC: O(n)
//SC: O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;           // base cases
        if(head.next == null) return head;
        
         // close the linked list into the ring
        ListNode oldTail = head;
        int length=1;
         while(oldTail.next!=null){
             oldTail = oldTail.next;
             length++;
         }
        oldTail.next = head;
        
        // find new tail : (length - k % length - 1)th node
        // and new head : (length - k % length)th node
        ListNode newTail = head;
        for(int i=0; i<length-k % length -1; i++)
            newTail = newTail.next;
        
        ListNode newHead = newTail.next;
        
        newTail.next = null;    // break the ring
        
        return newHead;
    }
}