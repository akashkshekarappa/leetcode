//Time Complexity :O(m*n log k)
//Space Complexity :O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
		int high = matrix[matrix.length-1][matrix.length-1];
		while(low < high){
			int mid = low + (high - low)/2;
			int count = 0;
			for(int i=0; i<matrix.length;i++){
				for(int j=0; j<matrix[0].length;j++){
					if(matrix[i][j] <= mid)
						count++;	// count the number of elements less than mid
				}
			}
			if(count < k)	// if the count is less than k, then move the low pointer to mid+1
				low = mid +1;
			else
				high = mid;	// if the count is greater than k, then move the high pointer to mid

		}
		return low;	//	now both low and high will pointing at k, so return either of them
    }
}