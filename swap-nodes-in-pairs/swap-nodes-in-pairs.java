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
//Recursive approach
//TC: O(n)
//SC: O(n)
class Solution {
    public ListNode swapPairs(ListNode head) {
        // If the list has no node or has only one node left.
        if((head == null) || head.next == null)
            return head;
        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        
        // Swapping
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        
        return secondNode;        // Now the head is the second node
    }
}