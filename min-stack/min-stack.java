class MinStack {
    Stack <Integer> stack = new Stack<>();
    int minValue = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    // we push min value and x also, if x is min
    public void push(int x) {
       //if x is less than or equal to min, then push to stack and make x as min
        if(x <= minValue){
            stack.push(minValue);
            minValue = x;
        }
        stack.push(x); 
    }
    
    //we pop min value and x also, if x is min
    public void pop() {
        int popped = stack.pop();
        // if popped value is equal to min, then make it as min
        if(popped == minValue)
            minValue = stack.pop();
    }
    
    public int top() {
        return stack.peek();    
    }
    
    public int getMin() {
        return minValue;
    }
}
​
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
