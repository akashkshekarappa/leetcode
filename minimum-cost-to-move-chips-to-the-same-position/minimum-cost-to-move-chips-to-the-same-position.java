//We just need to count the number of chips at the even positions and the number of chips at the odd positions and return the smaller one.
//TC: O(N)
//SC: O(1)
class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenCount = 0;
        int oddCount = 0;
        
        for(int i=0; i<position.length; i++){
            if(position[i] % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }
        return Math.min(oddCount, evenCount);
    }
}