//TC: O(log n)
//SC: O(1)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        // int bitMap = 0;
        // for(int i=0; i<nums.length; i++){
        //     bitMap ^= nums[i];
        // }
        // return bitMap;
        
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}