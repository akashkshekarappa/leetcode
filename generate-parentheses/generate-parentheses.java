//Backtracking
//TC: O(4^n / sqrt(n)) => O(n)
//SC: O(4^n / sqrt(n)) => O(n)
class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    private void backtrack( List<String> result, String curr, int open, int close, int n){
        if(curr.length() == n * 2){
            result.add(curr);
            return;
        }
        if(open < n){
            backtrack(result, curr+"(" , open +1, close, n);
        }
        if(close < open){
            backtrack(result, curr+")", open, close +1, n);
        }
    }
}