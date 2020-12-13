//Binary Search
//TC: O(n logn)
//SC: O(1)
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = nums[nums.length-1];
        while(low <= high){
            int mid = low+(high-low)/2;
            int sum = getSum(nums, mid);
            
            if(sum > threshold)
                low = mid+1;
            else
                high = mid-1;
        }
        return low; //return high;
        
    }
    
    private int getSum(int[] nums, int divisor){
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+= nums[i] / divisor +(nums[i] % divisor == 0 ? 0: 1);   
        }
        return sum;
    }
}
