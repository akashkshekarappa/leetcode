//TC: O(N)
//SC: O(N)
class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
    
        int[] dp = new int[s.length() + 1]; // to store no of ways to decode string of string s
        //base case
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;   //depends on value of 1st character
        
        for(int i=2; i<= s.length(); i++){
            //now at every situation, we use sub problem
           // int oneDigit = Integer.valueOf(s.substring(i-1, i));    //just getting integer value of char
            int twoDigit = Integer.valueOf(s.substring(i-2, i));
            
            // if(oneDigit >= 1){
            //     dp[i] += dp[i-1];
            // }
            
            // Check if successful single digit decode is possible.
            if(s.charAt(i-1) != '0') {
               dp[i] += dp[i-1];  
            }
​
            
            if(twoDigit >= 10 && twoDigit <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
