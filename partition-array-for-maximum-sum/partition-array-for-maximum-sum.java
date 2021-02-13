class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A == null || A.length == 0)
            return 0;
        
        int[] dp = new int[A.length];
        for(int i=0; i<A.length; i++){
            int max = A[i];
            for(int j=1; i-j+1 >=0 && j <= K; j++){ // iterate till max split possible
                max = Math.max(max, A[i-j+1]);  //updating max with each incoming values
                
                if(i >= j)
                    dp[i] = Math.max(dp[i], dp[i-j] + max * j);  //find value by taking value k splits previous to i and adding k times the max value from the values in split
                else    
                    dp[i] = Math.max(dp[i] , max * j);  // else  k times the max value from the values in split
            }
        }
        return dp[dp.length-1];
    }
}