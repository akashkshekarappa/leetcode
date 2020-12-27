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
//Time Complexity : O(nklog k), where nk is total number of elements in result and log k is time to heapify k list nodes
//Space Complexity : O(k), heap size
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);    // min heap on value of listnodes
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        for(ListNode firstNode_OfLists: lists){
            if(firstNode_OfLists != null)
                pq.add(firstNode_OfLists);  // add the first node of lists
        }
        
        while(!pq.isEmpty()){
            ListNode min = pq.poll();   // get the min value from top of the heap
            dummy.next = min;
            dummy = dummy.next;
            
            if(min.next != null)
                pq.add(min.next);   // add corresponding min value to queue
        }
        return result.next;
    }
}
