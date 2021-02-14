//Backtracking
//TC: O(n!)
//SC: O(n)
class Solution {
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        
        boolean[] used = new boolean[nums.length];
        
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        
        helper(nums, new ArrayList<>(), used);
        
        return new ArrayList(set);
    }
    
    private void helper(int[] nums, List<Integer> res, boolean[] used){
        //base
        if(nums.length == res.size()){
            set.add(new ArrayList<>(res));
            return;
        }
        
        
        for(int i=0; i<nums.length; i++){
            if(!used[i]){
                //action    
                res.add(nums[i]);
                used[i] = true;
            
                //recurse
                helper(nums, res, used);
            
                //backtrack
                res.remove(res.size()-1);
                used[i] = false;
            } 
        }
    }
}