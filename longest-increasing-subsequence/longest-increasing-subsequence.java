//Time Complexity :O(n log n), n is length of nums
//Space Complexity :O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
       if(nums == null || nums.length == 0)
            return 0;
        int[] arr = new int[nums.length];
        int len= 0;
        arr[len] = nums[0];
        len++;
        for(int i=1; i<nums.length; i++){
            //case1
            if(nums[i] > arr[len-1]){
                arr[len] = nums[i];
                len++;
            }
            else{
                //input is at its correct index, replace the just greater element
                int index = binarysearch(arr, 0, len, nums[i]);
                arr[index] = nums[i];
            }
        }
        return len;
    }
    private int binarysearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target)
                return mid;
            if(arr[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return low; // low ptr is always at the just greater element
    }
}