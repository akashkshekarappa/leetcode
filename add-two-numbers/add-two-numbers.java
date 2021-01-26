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
//TC: O(max(m,n))
//SC: O(max (m,n))
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummy;
        int carry = 0;
        
        while(p != null || q != null){
            int x = 0;
            int y = 0;
            if(p != null)
                x = p.val;
            if(q != null)
                y = q.val;
            
            int sum = carry + x + y;
            
            carry = sum / 10;
            
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            if(p != null)
                p = p.next;
            if(q != null)
                q = q.next;
        }
        if(carry > 0)
            curr.next = new ListNode(carry);
        
        return dummy.next;
    }
}
