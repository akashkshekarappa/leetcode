//Backtracking
//TC: O(n * 2^n)
//SC: O(n * 2^n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
		//base case
		if(nums == null || nums.length == 0)
			return result;

		Arrays.sort(nums);
		backtrack(nums, new ArrayList<>(), 0);
		return result;
    }
    private void backtrack(int[] nums, List<Integer> temp, int index){
		//base case


		//logic
		result.add(new ArrayList<>(temp));
		for(int i = index; i < nums.length; i++){
			 if(i > index && nums[i] == nums[i-1])
                continue;
			//action
			temp.add(nums[i]);
			//recurse
			backtrack(nums, temp, i+1);
			//backtrack
			temp.remove(temp.size()-1);
		}
    }
}