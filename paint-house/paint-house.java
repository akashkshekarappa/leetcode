// Time Complexity :O(n)
// Space Complexity : O(1)
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        
        for(int i=1; i<costs.length; i++){
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);//choose red, take the min from previous row green and blue and add to current value
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);//choose green, take the min from previous row red and blue and add to current value
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);//choose blue, take the min from previous row red and green and add to current value
        }
        return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1], costs[costs.length-1][2]));
    }
}
