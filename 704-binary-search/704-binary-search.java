//Time complexity: O(log n)
//Space complexity: O(1)
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)    //base case
            return -1;
        
        int low = 0;
        int high = nums.length -1;
        while(low <= high){ // low <= high for ex, given nums = 5 and target = 5
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
}