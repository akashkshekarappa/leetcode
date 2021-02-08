// Time Complexity : O(log n)
// Space Complexity : O(log n), recursive stack space
class Solution {
    public double myPow(double x, int n) {
        double result = 1;
        //base case
        if(n == 0)
            return 1;
        result = myPow(x, n/2); // call recursively on n/2 power and store in result each time
        if(n % 2 == 0){    //if power is even
            return result * result;
        }
        else{   // if power is odd
            if(n > 0)   // if n is +ve
                return x * result * result;
            else    // if n is -ve
                return  (result * result) / x;
        }
    }
}