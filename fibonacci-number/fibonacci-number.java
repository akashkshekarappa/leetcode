//Iterative
//TC: O(n)
//SC: O(1)
class Solution {
    public int fib(int N) {
        if(N <= 1)
            return N;
        if(N == 2)
            return 1;
        
        int first = 0;
        int second = 1;
        int third = 1;
        
        for(int i = 3; i <= N; i++){
            first = second + third;
            third = second;
            second = first;
        }
        return first;
    }
}