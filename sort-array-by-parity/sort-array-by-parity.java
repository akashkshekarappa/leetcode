//In place optimized soln
//TC: O(n)
//SC: O(1)
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int low=0; 
        int high = A.length-1;
        while(low < high){
            if(A[low] % 2 > A[high] % 2){
                int temp = A[low];
                A[low] = A[high];
                A[high] = temp; 
            }
​
            if(A[low] % 2 == 0)
                low++;
            if(A[high] % 2 == 1)
                high--;
        }
        
        return A;
    }
}
