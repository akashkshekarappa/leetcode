class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0; j<nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
​
/*
When nums[j] equals to the given value, skip this element by incrementing j. As long as nums[j] != val,
 we copy nums[j]to nums[i] and increment both indexes at the same time. Repeat the process until j reaches the end of the array and the new length is i.
​
This solution is very similar to the solution to Remove Duplicates from Sorted Array.
*/
