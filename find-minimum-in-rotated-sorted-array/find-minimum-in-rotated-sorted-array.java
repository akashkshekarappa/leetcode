//TC: O(logn)
//SC: O(1)
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if((mid==0 || nums[mid-1]>nums[mid]) && (mid == nums.length-1 || nums[mid+1]>nums[mid]))
                return nums[mid];
            else if(nums[mid] < nums[high])
                high = mid -1;
            else
                low = mid +1;
        }
        return -1;  
    }
}
