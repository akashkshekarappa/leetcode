//TC: O(n)
//SC: O(1)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int startPos = 0;
        for(int i=0; i<gas.length; i++){
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];
            
            if(currTank < 0){   // If one couldn't get here
                startPos = i+1; // Pick up the next station as the starting one.
                currTank = 0;// Start with an empty tank.
            }
        }
        return totalTank >= 0 ? startPos : -1;
    }
}