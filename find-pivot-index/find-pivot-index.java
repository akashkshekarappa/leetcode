//Prefix sum
/*Let's say we knew S as the sum of the numbers, and we are at index i. If we knew the sum of numbers leftsum that are to the left of index i, then the other sum to the right of the index would just be S - nums[i] - leftsum.
*/
//TC:O(n)
//SC:O(1)
class Solution {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int sum = 0;
        int leftsum = 0;
        for(int i=0; i<nums.length; i++)
            sum+= nums[i];
        for(int i=0; i<nums.length; i++){
            if(leftsum == sum-nums[i]-leftsum)
                return i;
            leftsum+= nums[i];
        }
        return -1;
    }
}