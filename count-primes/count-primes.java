//TC: O(n)
//SC: O(1)
class Solution {
    public int countPrimes(int n) {
       // isPrime[i] store whether num i is dividable by a prime num < i 
        boolean[] isPrime = new boolean[n];
        int count = 0;// count of prime nums so far
        for(int i=2; i<n; i++){// start from 2
            if(!isPrime[i]){// if i not dividable by a previous num, it's a prime
                count++; // count toward total num of primes seen so far
                for(int j=i; j<n; j+=i){ // mark all multiples of i as non-prime
                    isPrime[j] = true; 
                }
            }
        }
        return count;
    }
}
