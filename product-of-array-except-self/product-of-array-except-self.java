//Left and right product approach with O(1) space
//TC: O(n)
//SC: O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0)
            return new int[0];
        
        int[] result = new int[nums.length];
        
        result[0] = 1;
        for(int i=1; i<nums.length; i++)
            result[i] = result[i-1] * nums[i-1];
        
        int right = 1;
        for(int i= nums.length-1; i>=0; i--){
            result[i] = result[i] * right;
            right = right * nums[i];
        }
        return result;
    }
}
​
/*
//Left and right product approach
//TC: O(n)
//SC: O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0)
            return new int[0];
        
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];
        
        left[0] = 1;
        for(int i=1; i<nums.length; i++)
            left[i] = left[i-1] * nums[i-1];
        
        right[nums.length-1] = 1;
        for(int i= nums.length-2; i>=0; i--)
            right[i] = right[i+1] * nums[i+1];
        
        for(int i=0; i<nums.length; i++)
            result[i] = left[i] * right [i];
        
        return result;
    }
}
*/
