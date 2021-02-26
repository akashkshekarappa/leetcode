//Using Stack:stack is ideal since we only deal with operations involving the last or second-last valid round
//TC: O(N), where N is the length of ops
//SC: O(1),space used to store our stack
class Solution {
    public int calPoints(String[] ops) {
        if(ops == null || ops.length == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        for(String op: ops){
            if(op.equals("+")){//"+" - Record a new score that is the sum of the previous two scores.
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            }
            else if(op.equals("C")){//"C" - Invalidate the previous score, removing it from the record.
                stack.pop();
            }
            else if(op.equals("D")){//"D" - Record a new score that is double the previous score
                stack.push(2 * stack.peek());
            }
            else{
                stack.push(Integer.valueOf(op));
            }
        }
        //Return the sum of all the scores on the record(stack)
        int result = 0; 
        for(int score: stack){
            result+= score;
        }
        return result;
    }
}