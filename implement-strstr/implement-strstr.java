//Approach 1: Substring: Linear Time Slice
//TC: O(N-L)  * L , n is length of haystack and l is length of needle
//SC: O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        for(int i=0; i<haystack.length() - needle.length() + 1; i++){
            if(haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }
}