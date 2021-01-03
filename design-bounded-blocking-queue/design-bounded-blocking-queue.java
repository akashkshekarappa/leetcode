class BoundedBlockingQueue {
    private int capacity;
    private Queue<Integer> q;
​
    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.q = new LinkedList<>();
    }
    
    public synchronized void enqueue(int element) throws InterruptedException {
        while(q.size() == capacity){
            wait();
        }
        q.add(element);
        notifyAll();
    }
    
    public synchronized int dequeue() throws InterruptedException {
        while(q.isEmpty()){
            wait();
        }
        
        int result = q.poll();
        notifyAll();
        return result;
    }
    
    public int size() {
        return q.size();
    }
}
