//Brute Force
//TC: O(N ^3)
//SC: O(1)
// class Solution {
//     public boolean checkSubarraySum(int[] nums, int k) {
//         for(int start=0; start<nums.length-1; start++){
//             for(int end=start+1; end<nums.length; end++){
//                 int sum = 0;
//                 for(int i=start; i<=end; i++)
//                     sum+= nums[i];
//                 if(sum == k || (k != 0 && sum % k == 0))
//                     return true;
//                 }
//             }
//         return false;
//     }
// }

//TC: O(n)
//SC: O(min(n, k))
class Solution {
     public boolean checkSubarraySum(int[] nums, int k) {
         int sum = 0;
         Map<Integer, Integer> map = new HashMap<>();
         map.put(0, -1);
         for(int i=0; i<nums.length; i++){
             sum+= nums[i];
             if(k!=0)
                 sum = sum%k;
             
             if(map.containsKey(sum)){
                 if(i - map.get(sum) > 1)
                     return true;
             }
             else
                 map.put(sum, i);
         }
         
         return false;
     }
}