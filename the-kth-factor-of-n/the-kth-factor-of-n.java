//TC: O(k log k)
//SC: O(k)
​
class Solution {
    public int kthFactor(int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);  //max heap
        for(int i=1; i<=n; i++){
            if(n % i == 0)
            pq.add(i);
            
            if(pq.size() > k)
                pq.poll();
        }
        if(!pq.isEmpty() && pq.size() >= k)
            return pq.peek();   
        
        return -1;
    }
}
