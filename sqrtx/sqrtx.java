//Binary search
//TC: O(log n)
//SC: O(1)

class Solution {
    public int mySqrt(int x) {
        if(x == 0)
            return 0;
        
        int low = 1;
        int high = x;
        int result = 0;
        
        while(low <= high){
            int mid = low+ (high-low)/2;
            if(mid <= x/mid){
                low = mid+1;
                result = mid;
            }
            else
                high = mid-1;
        }
        return result;
    }
}