class Solution {
    public int calculate(String s) {
        Queue<Character> q=new LinkedList<>();
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			q.add(c);   
		}
		q.add('&');
		return helper(q);
	}

	private int helper(Queue<Character> q){
		char last_sign = '+';
		int number = 0;
		Stack<Integer> stack=new Stack<>();

		while(!q.isEmpty()){
			char c=q.poll();
			if(c==' ') 
				continue;

			if(Character.isDigit(c)){
				number=number*10+(c-'0');

			}else if(c=='('){
				number=helper(q);

			}else{
				//before updating new sign, we have to put current value into the stack
				if(last_sign=='+'){
					stack.push(number);
				}else if(last_sign=='-'){
					stack.push(-number);
				}
				else if(last_sign=='*'){
					stack.push(stack.pop()*number);
				}else if(last_sign=='/'){
					stack.push(stack.pop()/number);
				}
				//updating sign and num.
				number=0;
				last_sign=c;
				if(c==')') //break if its closing braces
					break;
			}

		}
		// now adding all numbers left in stack
		int result = 0;
		while(!stack.isEmpty()){
			result+= stack.pop();
		}
		return result;
    }
}