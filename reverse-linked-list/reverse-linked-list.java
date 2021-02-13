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
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)	// base condition, if 0 node or 1 node 
			return head;

		ListNode prev = null;
		ListNode curr = head;
		ListNode fast = head.next;	// fast pointer, so we dont loose the connection to next node where curr is supposed to go

		while(curr.next != null){ 	// till the next node is null
			curr.next = prev;	 // change the direction of currentNode.next to point to prev
			prev = curr;	// point prev to current 	
			curr = fast;	// point curr to fast 
			fast = fast.next;	// shift fast to next position
		}
		curr.next = prev;	// as the loop misses the last node, so change the currentNode.next to point to prev

		return curr; 
    }   
}

//Recursion
//O(n), O(n)
//public ListNode reverseList(ListNode head) {
//    if (head == null || head.next == null) return head;
//    ListNode p = reverseList(head.next);
//    head.next.next = head;
//    head.next = null;
//    return p;
//}