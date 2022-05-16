//TC: O(n)
//SC: O(1)
//Using Two Pointer Approach
// will swap the element if current pointer is zero and next is number, then increment both the pointers

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        
        int left = 0;
        int right = 0;
        
        while(right < nums.length){
            if(nums[right] == 0)
                right++;
            else{
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right++;
            }
        }
    }
}