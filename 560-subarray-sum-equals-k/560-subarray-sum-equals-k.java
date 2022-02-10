//Here we will be using map to store the previous sums which we have got and then after finding the new one we will be searching for the one which will be formed by subtracting this sum from k (if that exists that means we have got the subarray else we will only store the value of this new sum in the map.
//Time complexity : O(n)
//Space complexity: O(n)
/*Used Hashmap to store Key as cumulativeSum and value as count of cumulativeSum
 * If map contains key as cumulativeSum, then insert in to map with Key = cumulativeSum and value = count of cumulativeSum
 * If map contains key as cumulativeSum-k, then increment the total count as subarray sum
 * */
class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0)    //base case
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();// Key = cumulativeSum, value = count of cumulativeSum
        int cumulativeSum = 0;
        int totalCount = 0;
        
        map.put(0, 1);// Initializing with cumulativeSum 0, and count 1
        
        for(int i=0; i<nums.length; i++){
            cumulativeSum += nums[i];
            
            // if map contains a key (cumulativeSum-k), then increment the total count of subarray
            if(map.containsKey(cumulativeSum - k))
                totalCount += map.get(cumulativeSum - k);
            
            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0)+1);
        }
        return totalCount;
    } 
}