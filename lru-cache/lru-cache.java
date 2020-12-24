// Time Complexity : O(1), for put and get methods
// Space Complexity : O(N), N is size of the cache/ size of map
class LRUCache {
class Node{
        int key;
        int value;
        Node next;
        Node prev;
​
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private void addtoHead(Node node){  //O(1)
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
    private void removeNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
​
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
​
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
​
    public int get(int key) {
        Node node = map.get(key);
        if(node != null){
            int result = node.value;
            removeNode(node);
            addtoHead(node);
​
            return result;
        }
        return -1;
    }
​
    public void put(int key, int value) {
        //if the node is already exisiting in my cache
        if(map.containsKey(key)){
