//TC: O(NK), N = no of floors, K = egg
//SC: O(NK)
class Solution {
    public int superEggDrop(int K, int N) {
        int[][] result = new int[N + 1][K + 1]; //number of attempts along rows and eggs along columns
        //base
        //1st row and 1st col cells are zeros - (1st col - with 0 egss, max number of floors covered is 0 irrespective of number of attemps)
        //(1st row - with 0 attemps, max nummber of floors covered is 0 irrespective of number of eggs)
        int attempts = 0; //starting from 0th row
        while(result[attempts][K] < N)
        {
            attempts++; //increment attempts by 1 at start of each iteration of while()
            for(int egg = 1; egg <= K; egg++)
            {
                //if egg breaks, 1 attempt is used and remaining eggs is egg - 1
                //if egg doesn't break, 1 attempt is used and remaining eggs is egg
                //so max number of floors covered is 1 + sum of both possiblities
                result[attempts][egg] = 1 + result[attempts - 1][egg - 1] + result[attempts - 1][egg];
            }
        }
        return attempts;
    }
}