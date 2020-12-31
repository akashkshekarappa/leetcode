//Greedy Approach
//TC: O(n)
//SC: O(1)
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2)
            return true;
        // nums = [2,3,1,1,4]
        //destination = 4
        //i=nums.length-2 => 3
        //if(3 + 1 >= 4)
        // new destination = 3
        
        //i=nums.length-2 => 2
        //if(2 + 1 >= 3)
        // new destination = 2
        
        //i=nums.length-2 => 1
        //if(3 + 3 >= 2)
        // new destination = 1
        
        //i=nums.length-2 => 0
        //if(0 + 2 >= 1)
        // new destination = 0
        
        // if destionation == 0 return true;
        
        int destination = nums.length -1;
        for(int i=nums.length-2 ; i>=0; i--){
            if(i + nums[i] >= destination){
                destination = i;
            }
        }
        return destination == 0;
    }
}
