//Next array,  check whether max(left) <= min(right)
//TC: O(n)
//SC: O(n)
class Solution {
    public int partitionDisjoint(int[] A) {//A: [5,0,3,8,6]
        int[] maxLeft = new int[A.length];
        int[] minRight = new int[A.length];
        
        int m = A[0];
        for(int i=0; i<A.length; i++){
            m = Math.max(m, A[i]);
            maxLeft[i] = m;
        }//maxLeft: [5,5,5,8,8]
        
        m = A[A.length-1];
        for(int i=A.length-1; i>=0; i--){
            m = Math.min(m, A[i]);
            minRight[i] = m;
        }//minRight: [0,0,3,6,6]
        
        for(int i=1; i<A.length; i++){
            if(maxLeft[i-1] <= minRight[i])
                return i;
        }
        
        throw null;
    }
}