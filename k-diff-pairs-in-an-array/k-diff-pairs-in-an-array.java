//TC: O(n)
//SC: O(n)
class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        
        // if(k < 0)
        //     return 0;
        
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i]-k))
                result.add(nums[i]-k);
            if(set.contains(nums[i]+k))
                result.add(nums[i]);
            
            set.add(nums[i]);
        }
        return result.size();
    }
}