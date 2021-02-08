//Binary Search
//TC: O(log n)
//SC: O(1)
class Solution {
    public int findPeakElement(int[] nums) {
     int low = 0;
	int high = nums.length -1;
	            
	while(low <= high){
		int mid = low + (high-low)/2;
		
		//if element previous to mid is less than mid and element next to mid is less than mid, can return mid as peak
	    if((mid==0 || nums[mid-1] < nums[mid]) && (mid == nums.length-1 || nums[mid+1]<nums[mid]))
	    	return mid;
	    else if(mid > 0 && nums[mid] < nums[mid-1])		// if mid is less than previous element, then move the mid to first subarray
	    	high = mid-1;
	     else
	    	 low = mid +1;								//else move the mid to second subarray
	    }
	return -1;  
    }
}