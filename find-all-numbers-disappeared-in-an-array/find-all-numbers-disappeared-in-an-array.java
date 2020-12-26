/* By going through array, if the index is present as number in the array, change the number to negative, if its duplicate number, dont change anything as its already modified as negative number
 * Return the numbers of the indices that are positive in the array.*/
​
//Time Complexity : O(n)
//Space Complexity : O(1)
​
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       if(nums == null || nums.length == 0)
            return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int temp = nums[i];
            if(temp < 0)
                temp = temp * -1;
            if(nums[temp-1] > 0)        //go to each nums[temp-1] index and make it -nums[temp-1] if its not negative
                nums[temp-1] = nums[temp-1] * -1;
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0)
                result.add(i+1);
        }
        return result; 
    }
}
​
​
//HashSet
//TC: O(n)
//SC: O(n)
/*
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i: nums)
            set.add(i);
        
        for(int i=1; i<=nums.length; i++){
            if(!set.contains(i))
                list.add(i);
        }
        return list;
    }
}
*/
