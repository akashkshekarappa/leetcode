//Binary Search
//TC: (log n)
//SC: O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
		result[0] = firstPos(nums, target);
		result[1] = lastPos(nums, target);
		
		return result;
	}
	
	// to find first occurrence of an element in array
	public static int firstPos(int[] nums, int target) {
		int low = 0, high = nums.length-1;
		int first_pos = -1; 	// initialized first index as -1, if the element is not found in array
		while(low <= high) {
			int mid = low + (high-low) / 2;
			if(nums[mid] == target) {
				first_pos = mid;		// if mid is equal to target, then search in first half and assign mid to first index
				high = mid -1;
			}
			else if(target < nums[mid])
				high = mid -1;
			else
				low = mid +1;
		}
		return first_pos;
	}
	
	// to find last occurrence of an element in array
	public static int lastPos(int[] nums, int target) {
		int low = 0, high = nums.length-1;
		int last_pos = -1; 		// initialized last index as -1, if the element is not found in array
		while(low <= high) {
			int mid = low + (high-low) / 2;
			if(nums[mid] == target) {
				last_pos = mid;			// if mid is equal to target, then search in second half and assign mid to last index
				low = mid +1;
			}
			else if(target < nums[mid])
				high = mid -1;
			else
				low = mid +1;
		}
		return last_pos;
    }
}