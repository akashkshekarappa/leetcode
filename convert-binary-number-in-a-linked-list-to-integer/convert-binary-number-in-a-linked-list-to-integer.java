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
    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while(head.next != null){
            num = num * 2 + head.next.val;
            head = head.next;
        }
        return num;
    }
}