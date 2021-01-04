/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
//Recursive approach
//TC: O(n)
//SC: O(n)
class Solution {
    Node prev = null;   //Global variable pre to track the last node we visited
    public Node flatten(Node head) {
        if(head == null)
            return null;
        
        //Connect last visted node with current node
        if(prev != null){
            prev.next = head;
            head.prev = prev;
        }
        
        prev = head;
        
        /*Store head.next in a next pointer in case recursive call to flatten head.child overrides head.next*/
        Node next = head.next;
        
        flatten(head.child);
        head.child = null;
        
        flatten(next);
        return head;
    }
}
​
/*
Connect last visited node with current node by letting pre.next point to current node head and current node's prev point to pre
Mark current node as pre. pre = head
If there is head.child, we recursively visit and flatten its child node
Recursively visit and flatten its next node
*/
