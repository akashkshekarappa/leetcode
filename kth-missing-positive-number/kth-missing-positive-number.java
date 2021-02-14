//Binary Search
//TC: O(log n)
//SC: O(1)
class Solution {
    public int findKthPositive(int[] arr, int k) {
        if(arr == null || arr.length == 0)
            return 0;
        int low = 0;
        int high = arr.length;
        while(low < high){
            int mid = low + (high - low) /2;
            if(arr[mid] -(mid+1) >= k) //missed more or equal than k numbers, left side;
                high = mid;
            else
                low = mid+1;
        }
        return low+k;
    }
}