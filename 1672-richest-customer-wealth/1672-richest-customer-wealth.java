class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealthSoFar = 0;
        
        for(int i=0; i<accounts.length; i++){
            int currCustomerWealth = 0;
            for(int money : accounts[i])
                currCustomerWealth+= money;
            
            //Update the maximum wealth seen so far if the current wealth is greater  // If it is less than the current sum
        maxWealthSoFar = Math.max(maxWealthSoFar, currCustomerWealth);
            
        }
        return maxWealthSoFar;
    }
}