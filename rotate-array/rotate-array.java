//Using Reverse 
//Time Complexity :O(n), number of elements reversed
//Space Complexity :O(1)
/**First we reverse all the elements of the array
 * Then, reversing the first k elements followed by reversing the rest n-k elements gives us the required result
 * ***/
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return;
        if(k > nums.length)
            k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            start ++;
            end --;
        }
    }
}
