//TC: O(n)
//SC: O(n)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0)
            return T;
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<T.length; i++){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){  // till the stack is not empty and we can resolve the index to get a warmer day
                int index = stack.pop();    //resolved index;
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
