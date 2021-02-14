//Back tracking
//TC: O(K!)
//S: O(K)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(),k, n, 1);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int k, int n, int index){
        if(temp.size() == k && n == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=index; i<=9; i++){
            //action
            temp.add(i);
            //recurse
            backtrack(result, temp, k, n-i, i+1);
            //backtrack
            temp.remove(temp.size()-1);
        }
    }
}