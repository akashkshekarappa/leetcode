//Binary Search
//TC: O(log n)
//SC: O(1)
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1; //base case
        int low = 0; int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            //case 1: if target is mid, then return mid
            if(nums[mid] == target) return mid;
            //case 2: if right half is sorted array
            else if(nums[mid] < nums[high]){
                if(target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid -1;
            }
            //case 3: if left half is sorted array
            else if(nums[mid] >= nums[low]){
                if(target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }
}