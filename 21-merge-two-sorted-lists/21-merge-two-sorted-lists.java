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
// Iterative method
//TC: O(n + m)
//SC: O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }
            else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        
        if(l1 != null)
            dummy.next = l1;
        if(l2 != null)
            dummy.next = l2;
        
        return result.next;
    }  
}


/*
Recursive method
//TC: O(n + m)
//SC: O(n + m)

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }  
}
*/