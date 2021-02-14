/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
		ListNode fast = head;
		boolean flag = false;

		while(fast != null && fast.next!= null){	
			slow = slow.next;
			fast = fast.next.next;	 // fast pointer moves 2 nodes at a time

			if(slow == fast){
				flag = true;	 //if we find a cycle, set flag=true
				break;
			}    
		}

		if(!flag)		//Can't check slow!=fast as for 1 node the loop wont execute and they will be equal
			return null;

		slow = head;	// reset slow to start of list
		while(slow != fast){
			// increase slow and fast pointer by one
			slow = slow.next;
			fast = fast.next;
		}

		return fast;	// return the position they meet i.e start of the cycle
    }
}