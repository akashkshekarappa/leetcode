class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0)
            return result;
        
        backtrack(nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> temp, int index){
        
        result.add(new ArrayList<>(temp));
        
        for(int i=index; i<nums.length; i++){
            temp.add(nums[i]);
            backtrack(nums, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
}