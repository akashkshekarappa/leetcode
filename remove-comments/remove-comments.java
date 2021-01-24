//TC: O(S)
//SC: O(S)
​
//1. If we see '//' we stop reading the current line, and add whatever characters we have seen to the result.
//2. If we see '/*' then we start the multiline comment mode and we keep on ignoring characters until we see '*/'.
//3. If the current character is neither of the above two and the multiline comment mode is off, then we add that character to the current line.
​
class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean mode = false;
        for(String s : source){
            for(int i=0; i<s.length(); i++){
                if(mode){
                    if(s.charAt(i) == '*' && i < s.length() -1 && s.charAt(i+1) == '/'){
                        mode = false;
                        i++;    //skip '/' on next iteration of i
                    }
                }
                    
                else{
                    if(s.charAt(i) == '/' && i < s.length()-1 && s.charAt(i+1) == '/'){
                        break; //ignore remaining characters on line s
                    }
                    else if(s.charAt(i) == '/' && i < s.length()-1 && s.charAt(i+1) == '*'){
                        mode = true;
                        i++;//skip '*' on next iteration of i
                    }
                    else
                        sb.append(s.charAt(i));
                }   
            }
            if(!mode && sb.length() > 0){
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }
}
