//Greedy approach using Priority Queue
//TC: O(n logn)
//SC: O(n)
class Solution {
    public int connectSticks(int[] sticks) {
        if(sticks == null || sticks.length == 0);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();  //min heap;
        for(int i=0; i<sticks.length; i++)
            pq.add(sticks[i]);
        
        int sum = 0;
        while(pq.size() > 1){
            int two = pq.poll() + pq.poll();
            sum+= two;
            pq.add(two);
        }
        return sum;
    }
}