/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//Stack solution
//TC: O(n)
//SC: O(n)
class Solution {
    public Node expTree(String s) {
        s = "(" + s + ")";
        Stack<Node> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(!Character.isDigit(c) && c != '('){
                Node right = stack.pop();
                if(c == '*' || c == '/'){
                    if(stack.peek().val == '*' || stack.peek().val == '/'){
                        Node ops = stack.pop();
                        Node left = stack.pop();
                        ops.left = left;
                        ops.right = right;
                        right = ops;
                     }
                }
                else{
                    while(stack.peek().val != '('){
                        Node ops = stack.pop();
                        Node left = stack.pop();
                        ops.left = left;
                        ops.right = right;
                        right = ops;
                    }
                    if(c == ')')
                        stack.pop();
                }
                stack.push(right);
            }
            if(c != ')')
                stack.push(new Node(c));
        }
        return stack.pop();
    }
}

/*
adding a pair of parenthesis around the given string, which ensures that stack will end up having a single node (the result)
we look back to see if we can combine some nodes whenever we meet an operand (+, -, *, and /) or a closing parenthsis )
if the current char is * or /, we can combine the previous 2 numbers only if the previous char is a * or /.
Why? Think about 2+3*5, when we are at *, the previous 2 numbers cannot be combined, because we have to wait 3*5 to be executed first
if the current char is +, - or ), we need to use while loop to combine all adjacent nodes backward until hitting an openning parenthesis (
Why? Think about 2+3*5+2, when we are at the 2nd +, we first combine 3 and 5, but we cannot stop there, we have to continue to combine 2+(RESULTING_NODE_OF_3+5)
*/