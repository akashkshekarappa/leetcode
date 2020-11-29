//backtracking, two pointer
class Solution {
  public boolean isMatch(String s, String p) {
    int sLen = s.length(), pLen = p.length();
    int sPointer = 0, pPointer = 0;
    int sStar = -1, pStar = -1;
​
    while (sPointer < sLen) {
      //Case1: // If the pattern character = string character
      // or pattern character = '?'
      if (pPointer < pLen && (p.charAt(pPointer) == '?' || p.charAt(pPointer) == s.charAt(sPointer))){
        sPointer++;
        pPointer++;
      }
      // If pattern character = '*'
      else if (pPointer < pLen && p.charAt(pPointer) == '*') {
        // Check the situation, zero case
        // when '*' matches no characters
        sStar = sPointer;
        pStar = pPointer;
        pPointer++;
      }
      // If pattern character != string character or pattern is used up and there was no '*' character in pattern 
      else if (pStar == -1) {
        return false;
      }
      // If pattern character != string characte or pattern is used up and there was '*' character in pattern before
      else { // Backtrack: check the situation when '*' matches one more character
        pPointer = pStar + 1;
        sPointer = sStar + 1;
        sStar = sPointer;
      }
    }
​
    // The remaining characters in the pattern should all be '*' characters
    for(int i = pPointer; i < pLen; i++)
      if (p.charAt(i) != '*')
          return false;
      
    return true;
  }
}
