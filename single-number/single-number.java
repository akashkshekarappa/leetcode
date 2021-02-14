//TC: O(n)
//SC: O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int bitMask =0;
        //if numbers are same , i.e 2^2 = 0
        for(int i=0; i<nums.length; i++){
            bitMask ^= nums[i];
        }
        return bitMask;
    }
}