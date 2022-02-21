class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        
        Map.Entry<Integer, Integer> majority  = null;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(majority == null || entry.getValue() > majority.getValue())
                majority = entry;
        }
        return majority.getKey();
    }
}

// Moore voting algorithm
//TC: O(n)
//SC: O(1)
// class Solution {
//     public int majorityElement(int[] nums) {
//         int result = 0;
//         int count = 0;
//         for(int i=0; i<nums.length; i++){
//             if(count == 0)
//                 result = nums[i];
            
//             if(nums[i] != result)
//                 count--;
            
//             else count++;
//         }
//         return result;
//     }
// }


//Sorting
//TC: O(n logn)
//SC: O(1)
/*class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}*/

//HashMap
//TC: O(n)
//SC: O(n)
/*class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
            
            if(map.get(nums[i]) > nums.length/2){
                result = nums[i];
                break;
            }
        }
        return result;
    }
}*/

