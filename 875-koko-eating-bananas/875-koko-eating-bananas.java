//Binary search
//TC: O(n log m)
//SC: O(1)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;   // Initalize the left and right boundaries 
        int high = 1;
        for(int pile: piles)
            high = Math.max(high, pile);
        
        
        while(low < high){
            // Get the middle index between left and right boundary indexes.
            // hourSpent stands for the total hour Koko spends.
            int mid = low + (high - low)/2;
            int hourSpent = 0;
            
            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / middle)
            for(int pile: piles)
                hourSpent += Math.ceil((double) pile / mid);
            
            // Check if middle is a workable speed, and cut the search space by half.
            if(hourSpent <= h)
                high = mid;
            else
                low = mid + 1;
        }
        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return high;
    }
}