// Using Input Array for Output
//TC: O(n)
//SC: O(1)
class Solution {
    public int[] runningSum(int[] nums) {
       
        for(int i=1; i<nums.length; i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }
}