//TC: O(n)
//SC: O(1)
class Solution {
    public boolean validPalindrome(String s) {
        int low = 0;//low and high at by both the ends of the string
        int high = s.length()-1;
        
        while(low < high){
            if(s.charAt(low) == s.charAt(high)){//If both characters are equal then move both pointer towards end 
                low++;
                high--;
            }
            else{
                //If removing s[low] makes the whole string palindrome. We basically check if substring s[low+1..high] is palindrome or not. or s[low+..high-1]
                return isPalindrome(s, low+1, high) || isPalindrome(s, low, high-1);
               
            }
        }
        return true;
    }
    private boolean isPalindrome(String s, int low, int high){
        while(low < high){
            if(s.charAt(low) != s.charAt(high))//If both characters are equal then move both pointer towards end 
                return false;
            low++;
            high--;
        }
        return true;
    }
}
