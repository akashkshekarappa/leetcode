/*
Step 1. Convert the string to char[] array
Step 2. Whenever I encounter a space ' ' , I call the reverse function ( just to keep the code clean )
Step 3. Repeat till the end!
*/
class Solution {
    public String reverseWords(String s) {
        char[] s1 = s.toCharArray();
        int i=0;
        for(int j=0; j<s1.length; j++){
            if(s1[j] == ' '){
                reverse(s1, i, j-1);
                i = j+1;
            }
        }
        
        reverse(s1, i, s1.length-1);
        return new String(s1);
    }
    
    private void reverse(char[] s, int l, int r){
        while(l < r){
            char temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
    }
}


// //Using stringBuilder and reverse method
// //TC: O(n)
// //SC: O(n)
// class Solution {
//     public String reverseWords(String s) {
//         StringBuilder result = new StringBuilder();
//         StringBuilder word = new StringBuilder();
//         for(int i=0; i<s.length(); i++){
//             if(s.charAt(i) != ' ')
//                 word.append(s.charAt(i));
//             else{
//                 result.append(word.reverse());
//                 result.append(" ");
//                 word.setLength(0);
//             }
//         }
//         return result.append(word.reverse()).toString();
//     }
// }