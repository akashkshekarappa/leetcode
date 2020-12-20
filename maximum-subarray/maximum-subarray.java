//Approach: Greedy
//TC: O(n)
//SC: O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int runningSum = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++){   // start from 2nd value
            runningSum = Math.max(nums[i], runningSum + nums[i]);   // find running sum maximum as the sum till the point or if we consider the value alone and start from there
            max = Math.max(max, runningSum);    // update max based on running sum value
        }
        return max;
    }
}
