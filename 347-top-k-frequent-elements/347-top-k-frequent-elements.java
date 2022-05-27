//TC: O(N log k)
//SC: O(N + K)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //edge case
        if(nums == null || nums.length == 0)
            return new int[0];
        
        //map with key as nums and value as theircount
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
            
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        //PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));least frequent elements
        for(int i: map.keySet()){
            pq.add(i);
            
            if(pq.size() > k)
                pq.poll();
        }
        int[] result = new int[k];
        for(int i=k-1; i>=0; i--)
            result[i] = pq.poll();
        return result;
    }
}