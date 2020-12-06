//Min Heap
// Time Complexity :O(n log k), n is no of elements in array and for heapify it takes log k time
// Space Complexity : O(k), heap size
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)    
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // default min heap
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);    // add to the heap
​
            if(pq.size() > k)   // if the size exceeds k we pop, and heapfiy happens and min element comes at top and then we remove it
                pq.poll();
        }
        return pq.peek();   // at the end we have kth largest element remaining (as k-1 elements smaller are removed)
    }
}
