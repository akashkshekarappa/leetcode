//sliding window
//TC: O(n)
//SC: O(1)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int j=0;    // j is the slower pointer
        int result = Integer.MAX_VALUE;
        int sum = 0;
        
        for(int i=0; i<nums.length; i++){//i is the faster pointer
            sum+= nums[i];
            
            while(sum >= s){
                result = Math.min(result, i-j+1);// update global res.
                sum -= nums[j];// move the slower pointer forward and decrease the related nums[j], at the same time localAns will be decreased by 1.
                j++;
            }
        }
        return result == Integer.MAX_VALUE ? 0: result;
    }
}