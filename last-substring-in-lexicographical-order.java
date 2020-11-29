class Solution {
    public String lastSubstring(String s) {
        // We use "j" to find a better starting index. If any is found, we use it to update "i"
​
// 1."i" is the starting index of the first substring
// 2."j" is the staring index of the second substring
// 3."k" is related to substring.length() (eg. "k" is substring.length()-1)
​
// Case 1 (s[i+k]==s[j+k]):
// -> If s.substr(i,k+1)==s.substr(j,k+1), we keep increasing k.
// Case 2 (s[i+k]<s[j+k]):
// -> If the second substring is larger, we update i with j. (The final answer is s.substr(i))
// Case 3 (s[i+k]>s[j+k]):
// -> If the second substring is smaller, we just change the starting index of the second string to j+k+1. Because s[j]~s[j+k] must be less than s[i], otherwise "i" will be updated by "j". So the next possible candidate is "j+k+1".
​
        
        int k=0, i=0, j=1, n= s.length();
        while(j +k < n){
            if(s.charAt(i+k) == s.charAt(j+k))
                k++;
            
            else if(s.charAt(i+k) < s.charAt(j+k)){
                i=j;
                j++;
                k=0;
            }
            
            else if(s.charAt(i+k) > s.charAt(j+k)){
                j = j+ k + 1;
                k =0;
            }
        }
        // finally we return the substring from index i which points to largest character in the string S
        return s.substring(i);
    }
}
