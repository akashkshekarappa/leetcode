 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//TC: O(n)
//SC: O(h)
class Solution {
    public TreeNode str2tree(String s) {
        if(s.length() == 0)     //base case
            return null;
        Stack<TreeNode> stack = new Stack<>();
        int num = 0;
        int sign = 1;
        for(int i=0; i<s.length()+1; i++){
            char c= i<s.length() ? s.charAt(i) : '(';
            
            if(Character.isDigit(c))
                num = num * 10 + c - '0';
            else if(c == '('){
                if(s.charAt(i-1) != ')')// this is like the second ( in 2(3)(1)
                    stack.push(new TreeNode(num * sign));
                num = 0;
                sign = 1;
            }
            else if(c == '-')
                sign = -1;
            else{   // if(c == ')')
                TreeNode child = null;
                if(s.charAt(i-1) != ')'){//if the previous char is a number, we create a new node use this number, like 2(3)(1)
                    child = new TreeNode(num * sign);
                    sign = 1;
                }
                else //otherwise, we pop the topmost node, like 4(2(3)(1))
                    child = stack.pop();
                
                TreeNode curr = stack.peek();
                if(curr.left == null)
                    curr.left = child;
                else
                    curr.right = child;
            }
        }
        return stack.pop();//in the end there is only one node in the stack, which is root
    }
}
