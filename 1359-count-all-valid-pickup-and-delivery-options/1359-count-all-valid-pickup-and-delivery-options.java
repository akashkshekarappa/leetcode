/*
Given pair P1D1, we can insert P2D2 in following blanks: _ P1 _ D1 _ => #places = 3.

Fixing P2 at 1st blank: there're 3 options for D2; P2 at 2nd blank: 2 options for D2; P2 at 3rd blank: 1 option for D2 => 3+2+1 = 6 scenarios

Given 2 pairs P1D1P2D2(1 of the 6 cases, take this as example); P3D3 can be inserted at _P1_D1_P2_D2_: #places = 5; similarly, 5+4+3+2+1 scenarios.

3 pairs P1D1P2D2P3D3: _P1_D1_P2_D2_P3_D3_: #places = 7: 7+6+...+1 scenarios.

i.e.

i = 2: 3 places, (3+2+1) scenarios
i = 3: 5 places, (5+4+...+1) scenarios
i = 4: 7 places, (7+6+...+1) scenarios
dp formula generated.

1 <= n <= 500 => dp array size: 501.
*/
class Solution {
    public int countOrders(int n) {
        long mod = (long) 1e9+7;
        long[] dp = new long[501];
        
        dp[1] = 1;
        dp[2] = 6;
        
        for(int i=3; i<=n;  i++){
            int places = 2 * i - 1;
            int multi = places * (places + 1) /2 ;
            dp[i] = (dp[i-1] * multi) % mod;
        }
        
        return (int) dp[n];
    }
}