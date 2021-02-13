//Using Stack
//TC: O(n)
//SC: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0)
            return nums;
        Stack<Integer> stack = new Stack<>();
        
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        
        for(int i=0; i< 2 * nums.length; i++){  // circular array
            while(!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]){  // till stack is not empty and we have a next greater element for the index at stack peek
                int index = stack.pop();
                result[index] = nums[i % nums.length];
            }
            if(i < nums.length) // push only once not for the second round
                stack.push(i);
        }
        return result;
    }
}