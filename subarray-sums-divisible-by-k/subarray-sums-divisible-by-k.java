//Prefix sum
//TC: O(n)
//SC: O(K)
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int[] count = new int[K];    //O(K) space complexity
        count[0] = 1;
        int prefixSum = 0;
        int result = 0;
        for(int i=0; i<A.length; i++){
            prefixSum += A[i];
 
            prefixSum = (prefixSum % K + K) % K;
            result+= count[prefixSum]++;
        }
        return result;
    }
}
