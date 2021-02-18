//Binary Search
//TC: O(n log n)
//SC: O(1)

class Solution {
    public int missingElement(int[] nums, int k) {
        //edge case
        if(nums == null || nums.length == 0)
            return 0;
        
        int low = 0;
        int high = nums.length -1;
        while(low +1 < high){
            int mid = low + (high - low)/2;
            int missing = nums[mid] - nums[low] - (mid - low);
            if(missing >= k){
             // when the number is larger than k, then the index won't be located in (mid, high]
                high = mid;
            }
            else{
                low = mid;
                k = k-missing;
            }
        }
        if(nums[low] + k >= nums[high])
            return nums[low] + k + 1;
        
        return nums[low] + k;
    }
}