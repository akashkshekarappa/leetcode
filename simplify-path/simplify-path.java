class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList("..", ".", ""));
        
        for(String str: path.split("/")){
            if(str.equals("..") && !stack.isEmpty())
                stack.pop();
            else if(!set.contains(str))
                stack.push(str);
        }
        
        String result = "";
        for(String str: stack)
            result = "/" + str + result;
        
        return result.isEmpty() ? "/" : result;
            
    }
}