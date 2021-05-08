//Dynamic programming
//TC: O(n)
//SC: O(n)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //base case
        if(nums.length * k == 0)
            return new int[0];
        if(k == 1)
            return nums;
        
        int[] left = new int[nums.length];  left[0] = nums[0];
        int[] right = new int[nums.length]; right[nums.length - 1] = nums[nums.length -1];
        
        for(int i=1; i<nums.length; i++){
            if(i % k == 0) left[i] = nums[i]; //from left to right
            else //block start
                left[i] = Math.max(left[i-1], nums[i]);
            
            //from right to left;
            int j = nums.length - i -1;
            if((j + 1) % k == 0 )
                right[j] = nums[j];
            else    //block end
                right [j] = Math.max(right[j+1], nums[j]);
        }
        
        int[] result = new int[nums.length - k + 1];
        for(int i=0; i<nums.length -k +1; i++)
            result[i] = Math.max(left[i + k-1], right[i]);
        
        return result;
    }
}