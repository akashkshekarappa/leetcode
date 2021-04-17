//TC: O(n), where n is given number of elements in array
//SC: O(1)
//Her we care about 0 and the occurence of negative numbers in the array. No need to calculate the final product.
class Solution {
    public int arraySign(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0)// If there is a zero in the array return 0
                return 0;
            
            if(nums[i] < 0) // Count how many negative numbers in the array
                count++;
        }
        if(count % 2 == 0)// If there are even negative numbers, return 1
            return 1;
        
        return -1;// If there are odd negative numbers, return -1
    }
}