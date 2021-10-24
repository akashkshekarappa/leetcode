//Sliding Window
//TC: O(n)
//SC: O(1)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <=1)   //[1,2,3], 0
            return 0;
        
        int count = 0;
        int product = 1;
        int left = 0;
        
        for(int right = 0; right<nums.length; right++){
            product *= nums[right];
            
            while(product >= k){
                product = product / nums[left++];
            }
            
            count += right - left + 1;
        }
        return count;
    }
}