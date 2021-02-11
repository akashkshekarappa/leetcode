//TC: O(n * k)
class Solution {
    public int maxProfit(int k, int[] prices) {
        //edge case
        if(prices == null || prices.length == 0)
            return 0;
        
        // 1. If k > half the length of prices array then just check for adjacent elements and return maxProfit (same as buy and sell stock ii)

        //special case for handling Memory Limit Exceeded
        if(k >= prices.length / 2){
            int maxProfit = 0;
            //same as buy and sell stock ii
            for(int i=1; i<prices.length; i++){
                if(prices[i] > prices[i-1]){
                    maxProfit += prices[i] - prices[i-1];
                }
            }
            return maxProfit;
        }
        
         //2. If k < half the length of prices array then follow the approach in previous problem by creating buy and sell arrays and using the formula.
        
        //same as buy and sell stock iii
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        
        for(int price: prices){
            for(int i=1; i<=k; i++){
                buy[i] = Math.min(buy[i], price-sell[i-1]);    
                sell[i] = Math.max(sell[i], price - buy[i]);
            }
        }
        return sell[k];
    }
}