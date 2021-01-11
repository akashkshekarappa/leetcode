class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int best = 0;
        
        for(int i: set){
            if(!set.contains(i-1)){
                int j = i+1;
                while(set.contains(j))
                    j++;
                
                best = Math.max(best, j-i);
            }        
        }
        return best;
    }
}
