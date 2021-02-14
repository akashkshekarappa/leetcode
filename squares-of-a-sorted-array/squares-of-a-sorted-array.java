//Two pointer
//TC: O(n)
//SC: O(n)
class Solution {
    public int[] sortedSquares(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length -1;
        int index = nums.length-1;
        
        while(left <= right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                result[index] = nums[left] * nums[left];
                left++;
            }
            else {
                result[index] = nums[right] * nums[right];
                right --;
            }
            index--;
        }
        return result;
    }
}