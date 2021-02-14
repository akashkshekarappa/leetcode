//Backtrack with index
//Tc: O(2 ^N)
//SC: O(N)
class Solution {
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        targ = target;
        if(candidates == null || candidates.length == 0)
            return result;
        Arrays.sort(candidates);
        backtrack(candidates, new ArrayList<>(), 0, 0);
        return result;
    }
    private void backtrack(int[] candidates, List<Integer> temp, int sum, int index){
        //base case
        if(sum > targ)
            return;
        
        if(sum == targ){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = index; i <candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1])
                continue;
            //action
            temp.add(candidates[i]);
            //recurse
            backtrack(candidates, temp, sum + candidates[i], i+1);
            //backtrack
            temp.remove(temp.size()-1);
        }
    }
}