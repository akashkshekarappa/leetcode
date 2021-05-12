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

//Merge sort approach
//TC: O(log n)
//SC: O(1)
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        // step 3. merge l1 and l2
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){    //if l1 is small
                dummy.next = l1;    // point dummy to l1
                l1 = l1.next;   //move l1
            }
            else {  //if l2 is small
                dummy.next = l2;    // point dummy to l2
                l2 = l2.next;   //move l2
            }
            dummy = dummy.next; //move dummy each time
        }
        if(l1 != null)
            dummy.next = l1;
        
        if(l2 != null)
            dummy.next = l2;
        
        return result.next;
    }  
}