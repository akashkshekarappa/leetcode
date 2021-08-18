//Backtracking
//Time complexity: O(k * nCk)
//Spac Complexity: O(nCk)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(result, new ArrayList<>(), n , k, 1);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int n, int k, int index){
        if(temp.size() == k){    // if combination is done
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=index; i <=n; i++){
            //action
            temp.add(i);
            //recurse
            backtrack(result, temp, n, k, i+1);
            //backtrack
            temp.remove(temp.size()-1);
        }
    }
}