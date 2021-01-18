// Time Complexity : O(m*n), O(length of word1 * length of word2)
// Space Complexity : O(m*n), O(length of word1 * length of word2)
​
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1]; //dp matrix with extra row and col
        //fill the top row
        for(int i=1; i<dp[0].length; i++)
            dp[0][i] = i;   //word2 is empty in 1st row -> so delete chars in word1 to convert it to word2
        
        //fill the first column
        for(int i=1; i<dp.length; i++)
            dp[i][0] = i;   //word1 is empty in 1st col -> so delete chars in word2 to convert it to word1
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));    //Replace (diagonal up value), delete (same col prev row value), insert(same row prev col value)
                }
            }
        }
         return dp[m][n];
    }
}
