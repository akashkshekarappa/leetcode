//Adding 1 to n - 1 elements is the same as subtracting 1 from one element, w.r.t goal of making the elements in the array equal.
//So, best way to do this is make all the elements in the array equal to the min element.
//sum(array) - n * minimum
class Solution {
    public int minMoves(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int min = nums[0];
        int sum = 0;
        for(int i=0; i<nums.length; i++)
            min = Math.min(min, nums[i]);
        
        for(int i=0; i<nums.length; i++)
            sum+= nums[i] - min;
        
        return sum;
    }
}