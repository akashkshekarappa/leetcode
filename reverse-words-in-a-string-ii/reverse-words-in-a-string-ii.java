//Reverse the Whole String and Then Reverse Each Word
//TC: O(n)
//SC: O(1)
class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length -1); //reverse the whole string
        
        reverseEachWord(s); //reverse each word
    }
    private void reverse(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    private void reverseEachWord(char[] s){
        int start = 0;
        int end = 0;
        while(start < s.length){
            while(end < s.length && s[end] != ' ')  //go to the end of word
                end++;
            
            reverse(s, start, end-1);   //reverse the word
            
            start = end+1;
            end++;
        }
    }
}