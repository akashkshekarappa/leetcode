//Using Hashmap
//TC: O(n)
//SC: O(n)
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0)    //base case
            return 0;
        int cumulativeSum = 0;
        int maxSize = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            cumulativeSum += nums[i];
            
            if(cumulativeSum == k)
                maxSize = i + 1;
            else if(map.containsKey(cumulativeSum - k))
                maxSize = Math.max(maxSize, i - map.get(cumulativeSum - k));
            
            if(!map.containsKey(cumulativeSum))
                map.put(cumulativeSum, i);
        }
        return maxSize;
    }
}