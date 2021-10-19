class Solution {
    public int searchInsert(int[] nums, int target) {
        //base case
        if(nums == null || nums.length == 0)
            return 0;
        int low = 0;
        int high = nums.length -1;
        while(low <= high){
            int mid = low+ (high - low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return low; //this line is key for solution, we do normal binary search, at any time given target is not found means it will be near low pointer, hence returning low gives the result
    }
}