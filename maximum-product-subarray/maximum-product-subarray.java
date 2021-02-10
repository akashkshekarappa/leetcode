//Brute Force
//TC: O(n^2)
//SC: O(1)
class Solution {
    public int maxProduct(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0)
            return 0;
        
        int maxProduct = nums[0];
        for(int i=0; i<nums.length; i++){
            int accumulate = 1;
            for(int j=i; j<nums.length; j++){
                accumulate = accumulate * nums[j];
                maxProduct = Math.max(maxProduct, accumulate);
            }
        }
        return maxProduct;
    }
}