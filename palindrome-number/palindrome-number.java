//TC: O(log n)
//SC: O(1)
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        
        int y = x;
        int result = 0;
        while(y != 0){
            result = result * 10 + y % 10;
            y = y/10;
        }
        return x == result;
    }
}