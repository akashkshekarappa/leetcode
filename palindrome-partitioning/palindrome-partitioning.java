//Backtraing: Return "all possible" palindrome partitioning
//TC: O(n 2^n)
//SC: O(n)
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        //base case
        if(s == null || s.length() == 0)
            return result;
​
        backtrack(s, new ArrayList<>(), 0);
        return result;
    }
​
    private void backtrack(String s, List<String> temp, int start){
        //base case
        if(start >= s.length()) // if start reaches end of string, when no characters left to process
            result.add(new ArrayList<>(temp));
​
        //logic
        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, start, i)){  //check if substring is palindrome
                //action
                temp.add(s.substring(start, i+1));
                //recurse
                backtrack(s, temp, i+1);    // backtrack(s.substring(i), temp, 0+1);
                //backtrack
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end){
        if(start == end)
            return true;
​
        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;
​
            start++;
            end--;
        }
        return true;
    }
}
