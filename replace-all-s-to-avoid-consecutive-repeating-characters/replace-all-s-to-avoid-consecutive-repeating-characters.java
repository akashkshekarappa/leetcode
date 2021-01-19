//TC: O(n)
class Solution {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            if(arr[i] == '?'){
                for(char c = 'a'; c<='z'; c++){ //iterate from 'a' to 'c'
                    if(i > 0 && arr[i-1] == c)
                        continue;
                    
                    if(i+1 < arr.length && arr[i+1] == c)
                        continue;
                    
                    arr[i] = c;
                    break;
                }
            }
        }
        return String.valueOf(arr);
    }
}
