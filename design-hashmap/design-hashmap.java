class MyHashMap {
    Node[] nodes = new Node[10000];
    
    private class Node{
        int key, value;
        Node next;
        
        Node(int k, int v){
            key = k;
            value = v;
        }
    }
​
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        Node prev = findElement(index, key);
        if(prev.next == null)
            prev.next = new Node(key, value);
        else
            prev.next.value = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        Node prev = findElement(index, key);
        if(prev.next == null)
            return -1;
        else
            return prev.next.value;    
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        Node prev = findElement(index, key);
        if(prev.next != null){
            prev.next = prev.next.next;
        }
        
    }
    
    private int getIndex(int key){
        return Integer.hashCode(key) % 10000;
    }
    
    private Node findElement(int index, int key){
        if(nodes[index] == null)
            return nodes[index] = new Node(-1,-1);
        
        Node previousNode = nodes[index];
        while(previousNode.next != null && previousNode.next.key != key){
            previousNode = previousNode.next;
        }
        return previousNode;
    }
}
​
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
