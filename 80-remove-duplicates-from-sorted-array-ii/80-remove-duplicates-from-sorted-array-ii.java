//TC: O(n)
//SC: O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int i=0; 
        int count = 1;
        
        for(int j=1; j<nums.length; j++){// Start from the second element of the array and process elements one by one.
            if(nums[j] == nums[j-1])// If the current element is a duplicate, increment the count.
                count++;
            
            else
                count=1;
            
            if(count <= 2){// For a count <= 2, we copy the element over thus
            // overwriting the element at index "i" in the array
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1; //return j;
    }
}