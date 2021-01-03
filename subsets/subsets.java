class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        //base case
        if(nums == null || nums.length == 0)
            return result;
​
        /** Arrays.sort(nums);  https://leetcode.com/problems/subsets-ii/*/
        backtrack(nums, new ArrayList<>(), 0);
        return result;
    }
    private void backtrack(int[] nums, List<Integer> temp, int index){
        //base case
​
​
        //logic
        result.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++){
            /** if(i > index && nums[i] == nums[i-1])
                continue; https://leetcode.com/problems/subsets-ii/**/
            //action
            temp.add(nums[i]);
            //recurse
            backtrack(nums, temp, i+1);
            //backtrack
            temp.remove(temp.size()-1);
        }
    }
}
