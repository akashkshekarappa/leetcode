//Using Reverse 
//Time Complexity :O(n), number of elements reversed
//Space Complexity :O(1)
/**First we reverse all the elements of the array
 * Then, reversing the first k elements followed by reversing the rest n-k elements gives us the required result
 * ***/
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return;
        if(k > nums.length)
            k = k % nums.length;
        reverse(nums, 0, nums.length-1); //reverse all
        reverse(nums, 0, k-1);          //reversing the first k elements
        reverse(nums, k, nums.length-1);//reversing the rest n-k elements
	}
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            start ++;
            end --;
        }
    }
}

/*
//Time Complexity :O(n), n is length of array
//Space Complexity :O(n), size of new array

class Solution {
	public void rotate(int[] nums, int k) {
		int[] arr = new int[nums.length];
		//rotating array 
		for(int i=0; i<nums.length; i++){
			arr[(i+k) % nums.length] = nums[i];
		}
		//Assigning rotated array to original array  
		for(int i=0; i<nums.length; i++){
			nums[i] = arr[i];
		}
	}
}
*/