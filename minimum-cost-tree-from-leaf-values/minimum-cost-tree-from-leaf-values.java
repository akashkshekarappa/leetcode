//TC: O(n)
//SC: O(n)
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int i=0; i<arr.length; i++) {
            while (stack.peek() <= arr[i]) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), arr[i]);
            }
            stack.push(arr[i]);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}