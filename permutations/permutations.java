class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return result;
        
        helper(nums, new ArrayList<>());
        
        return result;
    }
    
    private void helper(int[] nums, List<Integer> res){
        //base
        if(nums.length == res.size()){
            result.add(new ArrayList<>(res));
            return;
        }
        
        
        for(int i=0; i<nums.length; i++){
            //action
            if(res.contains(nums[i]))
                continue;
            
            res.add(nums[i]);
            
            //recurse
            helper(nums, res);
            
            //backtrack
            res.remove(res.size()-1);
        }
    }
}
