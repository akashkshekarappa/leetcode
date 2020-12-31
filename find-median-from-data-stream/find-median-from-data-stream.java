//Each element is added to minheap first --> step1
// Then the min element is popped out and added to maxheap --> step2
//this assures all elements in minheap are greater than max heap
//finally the two heaps need to be load balanced --> step 3
class MedianFinder {
​
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue(Collections.reverseOrder());  
        minHeap = new PriorityQueue<>();
    }
    
    //TC: O(logn)
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        
        if(minHeap.size() < maxHeap.size())
            minHeap.add(maxHeap.poll());
    }
    
    //TC:  O(1)
    public double findMedian() {
        if(minHeap.size() > maxHeap.size())
            return minHeap.peek();
        else
            return (minHeap.peek() + maxHeap.peek()) /2.0;
    }
}
​
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
