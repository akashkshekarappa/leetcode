//Time Complexity : O(n^2)
//Space Complexity : O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 2)
            return s;
        
        int start = 0;  // start and end to track the longest palindrom so far
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            for(int j=i; j>=0; j--){
                if(s.charAt(i) == s.charAt(j) && (i-j < 2 || dp[i-1][j+1])){
                    dp[i][j] = true;
                    //update start and end when a longer palindrome is found
                    if(i - j > end - start){
                        start = j;
                        end = i;
                    }
                }
            }
        }
    return s.substring(start, end +1);
    }
}
