//Here we will be iterating over the whole array and whenever we will find zero we will increment our number of zeros and when we are getting 1 we will reduce the number of zeros by 1 and whenever we will get our zero equal to 0 that means we are at a point where our array till that point contains equal number of 1's and 0's so we will update the max size to index we are at right now +1. then we will put the put the value of zero in map if new value of zero is already there in the map else will update our max value to the max of current value of max or the index where we at right now - the value of the (zero value) in the map.
// Time Complexity : O(n)
// Space Complexity : O(n)
class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0)    //base case
            return 0;
        int count = 0;
        int maxLength = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initializing map with zero as count and -1 as index(not present)
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0)// if zero if found, subtract the count by -1
                count+= -1;
            else            // else, add the count by 1
                count+= 1;
            
            if(map.containsKey(count))
                maxLength = Math.max(maxLength, i - map.get(count));
            else
                map.put(count, i);
        }
        return maxLength;
    }
}