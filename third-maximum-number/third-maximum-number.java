class Solution {
    public int thirdMax(int[] nums) {
        // if(nums == null || nums.length == 0)
        //     return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(!set.contains(nums[i])){
                pq.add(nums[i]);
                set.add(nums[i]);
                
                if(pq.size() > 3)
                    set.remove(pq.poll());
                }
            }
        if(pq.size() < 3){   // for array less than 3 and heap less than 3 elements
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
            
    }
}