//Two pointer
//TC: O(nlogn + n^2)
//Sc: O(log n)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);  // O(n logn)
        
        for(int i=0; i<nums.length; i++){ // O(n)
            int low = i+1;
            int high = nums.length -1;
            
            while(low < high){  //O(n) --->O(n^2)
                int sum = nums[i] + nums[low] + nums[high];
                //if the absolute difference between sum and target is smaller than the absolute value of diff: //Set diff to target - sum.
                if(Math.abs(target - sum) < Math.abs(diff)){
                    diff = target - sum;
                }
                if(sum < target)
                    low++;
                else
                    high--;
            }
        }
        //Return the value of the closest triplet, which is target - diff.
        return target - diff;
    }
}