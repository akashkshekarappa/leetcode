//DP
//TC: O(n)
//SC: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        //edge case
        if(prices == null || prices.length == 0)
            return 0;
        
        int sold = Integer.MIN_VALUE;
        int held = Integer.MIN_VALUE;
        int reset = 0;
        //sold[i]: the previous state of sold can only be held.
        //held[i]: the previous state of held could also be held
        //reset[i]: the previous state of reset could either be reset or sold
        
        for(int i=0; i<prices.length; i++){
            int presold = sold;
            
            sold = held + prices[i];
            held = Math.max(held, reset - prices[i]);
            reset = Math.max(reset, presold);
        }
        return Math.max(sold, reset);
    }
}