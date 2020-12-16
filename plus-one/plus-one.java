//TC: O(n)
//SC: O(1)
class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--){// move along the input array starting from the end
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;// set all the nines at the end of array to zeros
        }
        digits = new int[digits.length+1];// we're here because all the digits are nines
        digits[0] = 1;
        
        return digits;
    }
}
