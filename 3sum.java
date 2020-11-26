/* Used Sorting to obtain result and is solved in O(n^2) time.
 * Using two pointers low(pointing to the index after current number) and high (pointing to last number).
 * First, calculate the sum of these 3 numbers and if sum is equal to 0, append to result, and increment low and decrement high.
 * as array is sorted, if sum is less than 0, move to the right else move left
 * */
//Time Complexity : O(n^2)
//Space Complexity : O(1)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3)
            return result;
        
        Arrays.sort(nums);
        
        for(int i = 0 ; i< nums.length -2; i++){
            if(i > 0 && nums[i-1] == nums[i])       //nums[i-1] == nums[i] used for avoiding outer duplicacy, if nums[i] checked once, if same value occured at nums[i+1], move i to next value
                continue;
            
            int low = i+1;
            int high = nums.length-1;
            
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                
                if(sum == 0){
                    List<Integer> current = Arrays.asList(nums[i], nums[low], nums[high]);
                    result.add(current);
                    low++;
                    high--;
                    
                    // used for avoiding inner duplicacy, since low, high changed, check base case again 
                    // similar strategy for duplicacy removal in outer loop
                    while(low < high && nums[low] == nums[low - 1])
                        low++;
                    while(low < high && nums[high] == nums[high + 1])
                        high--;
                }
                else if(sum < 0)
                    low++;
                else 
                    high --;
            }
        }
        return result;
    }
}
