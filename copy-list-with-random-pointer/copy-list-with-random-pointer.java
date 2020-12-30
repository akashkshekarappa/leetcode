        
        while(ptr_Old_List != null){
            ptr_Old_List.next = ptr_Old_List.next.next;
            
            if(ptr_New_List.next != null)
                ptr_New_List.next = ptr_New_List.next.next;
            
            ptr_Old_List = ptr_Old_List.next;
            ptr_New_List = ptr_New_List.next;
        }
        return head_old;
    }
}
*/
​
​
​
//TC: O(n), SC: O(n)
public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();//map to hold old node as key and new node as value
        Node temp = head;
​
        while(temp != null){
            Node cloneNode = new Node(temp.val);    //cloning the data initially from original list
            map.put(temp, cloneNode);   //inserting the original and cloned node in map
            temp = temp.next;   //moving temp to next
        }
​
        temp = head;
​
        while(temp != null){
            Node curr = map.get(temp);  // get the curr node from map
            curr.next = map.get(temp.next);     //pointing original node.next to curr.next
​
            curr.random = map.get(temp.random);  //pointing original node.random to curr.random
​
            temp = temp.next;
​
        }
        return map.get(head);
    }
}
