/*Since the numbers need to consecutive we immediately can figure out the next k - 1 numbers that must occur after a given number. By using a priority queue we can poll the smallest number and remove the next k - 1 consecutive numbers. If any of the consecutive numbers are not in the priority queue, it implies the hand is invalid and thus returns false.*/
​
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return false;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: nums)
            pq.add(i);
        
        while(!pq.isEmpty()){
            int curr = pq.poll();
            for(int i=1; i<k; i++){
                if(pq.remove(curr + i))
                    continue;
                else
                    return false;
            }
        }
        return true;
    }
}
