/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
// Time Complexity : O(log n)
// Space Complexity : O(1)

/* Binary Search Approach having 2 pointers to find the range
 * The Second pointer will be incremented in 2^p and first pointer will be replaced by second*/
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        
        while(reader.get(high) < target){
            low = high;
            high = 2 * high;
        }
        
        //binary search
        while(low <= high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target)
                return mid;
            else if(target < reader.get(mid))
                high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}