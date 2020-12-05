//TC: O(n)
//SC: O(n)
class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums.length == 0)//base case
            return 0;
        
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++){
            if(!count.containsKey(nums[i])){
                count.put(nums[i], 0);
                start.put(nums[i], i);
            }
            
            end.put(nums[i], i);
            
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
            max = Math.max(max, count.get(nums[i]));
        }
        int min = Integer.MAX_VALUE;
        
        for(Integer key: count.keySet()){
            if(count.get(key) == max){
                min = Math.min(min, end.get(key) - start.get(key) + 1);            }
        }
        return min;
    }
}
