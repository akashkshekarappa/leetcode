//Using Bit Manipulation
//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        //if numbers are same , i.e 2^2 = 0
        for(int i=0; i<nums.length; i++)
            result = result ^ nums[i];
        
        return result;
    }
}


// //Using HashMap
// //Time Complexity: O(n)
// //Space Complexity: O(n)
// class Solution {
//     public int singleNumber(int[] nums) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int i=0; i<nums.length; i++)
//             map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
//         for(int i=0; i<nums.length; i++){
//             if(map.get(nums[i]) == 1)
//                 return nums[i];
//         }
//         return 0;
//     }
// }