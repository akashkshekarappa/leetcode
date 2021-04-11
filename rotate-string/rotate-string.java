//Simple check
/*
“abcdeabcde” (A + A)
  “cdeab” (B)
*/
//TC: O(n^2)
//SC: O(1)
class Solution {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}