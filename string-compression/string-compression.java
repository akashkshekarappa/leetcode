//TC: O(n), n is no of characters in string
//SC: O(1)
class Solution {
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0)//edge case
            return 0;
        
        int len = 0;    
        int count = 1; //to denote the no of times char appears
        
        for(int i=1; i<=chars.length; i++){
            if(i < chars.length && chars[i] == chars[i-1])//avoid post processing for last char
                count++;
            else{
                chars[len++] = chars[i-1];
                
                if(count <= 1)//if count freq < 2, do not append; just continue;
                    continue;
                
                String s = String.valueOf(count);
                for(int k=0; k<s.length(); k++){
                    chars[len++] = s.charAt(k);
                }
                
                count = 1;  //after append, reset count to 1
            }
        }
        return len;
    }
}