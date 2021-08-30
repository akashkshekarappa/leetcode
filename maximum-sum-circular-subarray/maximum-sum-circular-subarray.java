//Maximum subarray format
//TC: O(n)
//SC: O(1)
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int currMax = 0;
        int currMin = 0;
        for(int i=0; i<nums.length; i++){
            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currMax);
            
            currMin = Math.min(currMin + nums[i], nums[i]);
            minSum = Math.min(minSum, currMin);
            
            total+= nums[i];
        }
        
        return maxSum > 0 ? Math.max(maxSum, total -  minSum) : maxSum;
    }
}