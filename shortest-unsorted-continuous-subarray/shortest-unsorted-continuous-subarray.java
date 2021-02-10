//Using Stack
//TC: O(n)
//SC: O(n)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Stack<Integer> st = new Stack<>();
        int left = nums.length;
        int right = 0;
        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                left = Math.min(left, st.pop());
            }
            st.push(i);
        }
        st.clear();
        
        for(int i=nums.length-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] < nums[i])
                right = Math.max(right, st.pop());
            
            st.push(i);
        }
        
        
        if(right - left > 0)
            return right - left +1;
        
        return 0;
    }
}