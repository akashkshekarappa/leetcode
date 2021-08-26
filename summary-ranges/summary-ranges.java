//The array is sorted and without duplicates. In such array, two adjacent elements have difference either 1 or larger than 1. If the difference is 1, they should be put in the same range; otherwise, separate ranges.

//TC: O(n)
//SC: O(1)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int val = nums[i];
            
            while(i+1 < nums.length && (nums[i+1] - nums[i]) == 1)
                i++;
            
            if(val != nums[i])
                result.add(val + "->" + nums[i]);
            else
                result.add(val + "");
        }
        return result;
    }
}