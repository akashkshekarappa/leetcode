//Two Pointers
//TC: O(n logn)
//SC: O(logn)
class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        //edge case
        if(A == null || A.length == 0)
            return 0;
        Arrays.sort(A);
        int low = 0;
        int high = A.length -1;
        int s = -1;
        while(low < high){
            int sum = A[low] + A[high];
            if(sum < K){
                s = Math.max(s, A[low] + A[high]);
                low ++;
            }
            else
                high --;
        }
        return s;
    }
}
