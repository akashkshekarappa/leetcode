//Dp
//Time Complexity : O(n^3)
//Space Complexity : O(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0)
            return true;
​
        Set<String> set = new HashSet<>(wordDict);
        
        boolean[] dp = new boolean[s.length() + 1]; //dp array
        
        dp[0] = true;    // set the first value to true 
​
        for(int i=0; i<dp.length; i++){ // O(n^2)
            for(int j=0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){    // O(n)
                    dp[i] = true;   // set the value for the position as true i.e prior to that, we have found words in the dictionary
                }
            }
        }
        return dp[dp.length-1];
    }
}
​
​
/*
​
//Brute force
//Time Complexity : O(n^n)
//Space Complexity : O(n)
class Solution {
    Set<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return helper(s);
    }
    private boolean helper(String s){
        if(s.length() == 0)
            return true;
        for(int i=0; i<=s.length(); i++){
            if(set.contains(s.substring(0,i)) && helper(s.substring(i)))
                return true;
        }
        return false;
    }
}*/
