
//Time Complexity : O(n)
//Space Complexity : O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3)
			return 0;
		int sum = 0;
		int dp  = 0;
		for(int i=2; i<A.length; i++){
			if(A[i-1] - A[i-2] == A[i] - A[i-1]){
				dp++;
				sum+= dp;
			}
            else
                dp = 0;
		}
		return sum;
    }
}