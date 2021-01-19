    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(count == 0)
            return false;
        headIndex = (headIndex + 1) % capacity;
        count -=1;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
       if(count == 0)
           return -1;
        return queue[headIndex];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(count == 0)
            return -1;
        int tailIndex = (headIndex + count -1) % capacity;
        return queue[tailIndex];
    }
    
     /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count == capacity;
    }
}
​
/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
