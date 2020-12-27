                l1 = l1.next;   //move l1
            }
            else {  //if l2 is small
                dummy.next = l2;    // point dummy to l2
                l2 = l2.next;   //move l2
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
​
/*
Recursive method
​
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
