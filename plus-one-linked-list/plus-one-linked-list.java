/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
​
//TC: O(n), n is length of input
//SC: O(1)
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode notNine = sentinel;
        
        while(head != null){
            if(head.val != 9){
                notNine = head;
            }
            head = head.next;
        }
        
        notNine.val++;
        notNine = notNine.next;
        
        while(notNine != null){
            notNine.val = 0;
            notNine = notNine.next;
        }
        
        return sentinel.val != 0 ? sentinel : sentinel.next;
    }
}
