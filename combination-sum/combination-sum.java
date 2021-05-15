//Backtracking
//TC: O(N ^(T/M +1)),N be the number of candidates, T be the target value, and M be the minimal value among the candidates.
//SC:  O(N ^(T/M ))

class Solution {
    List<List<Integer>> result;
	int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       result = new ArrayList<>();
		targ = target;
		//edge case
		if(candidates == null || candidates.length == 0)
			return result;
        
		backtrack(candidates, new ArrayList<>(), 0, 0);	//calling function on the given array, using a temp list, sum and index to track the candidates array
		return result; 
    }
    private void backtrack(int[] candidates, List<Integer> temp, int sum, int index){
		//base
		if(sum > targ || index >= candidates.length)
			return;

		if(sum == targ){
			result.add(new ArrayList<>(temp));	// add the copy of temp till the point to result
			return;
		}

		//logic
		for(int i=index; i<candidates.length; i++){
			//action
			temp.add(candidates[i]);

			//recurse
			backtrack(candidates, temp, sum + candidates[i], i);	//calling recursive function with increasing sum, new temp and on index as i

			//backtrack
			temp.remove(temp.size()-1);	//return back to one step back when base case hits, to traverse other possible paths
		}
    }
}