//TC: O(max(n1, n2))
//SC: O(max(n1, n2))
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        while(p1 >= 0 || p2 >= 0){
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            
            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            
            result.append(value);
            p1--;
            p2--;
        }
        if(carry != 0)
            result.append(carry);
        
        return result.reverse().toString();
    }
}
​
/*
Initialize an empty res structure. Once could use array in Python and StringBuilder in Java.
​
Start from carry = 0.
​
Set a pointer at the end of each string: p1 = num1.length() - 1, p2 = num2.length() - 1.
​
Loop over the strings from the end to the beginning using p1 and p2. Stop when both strings are used entirely.
​
Set x1 to be equal to a digit from string nums1 at index p1. If p1 has reached the beginning of nums1, set x1 to 0.
​
Do the same for x2. Set x2 to be equal to digit from string nums2 at index p2. If p2 has reached the beginning of nums2, set x2 to 0.
​
Compute the current value: value = (x1 + x2 + carry) % 10, and update the carry: carry = (x1 + x2 + carry) / 10.
​
