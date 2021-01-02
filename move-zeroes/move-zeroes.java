//TC: O(n)
//SC: O(1)
//Using Two Pointer Approach
// will swap the element if current pointer is zero and next is number, then increment both the pointers
​
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        
        int left = 0, right = 0;
        int temp;
        while(right < nums.length){
            if(nums[right] == 0){
                right++;    // move only right when its 0
            }
            else{   //if number, then swap and increment both pointers
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right++;
            }
        }
    }
}
