//Time Complexity : O(n!), no of valid permutations
//Space Complexity : O(n), depth of recursive call stack
class Solution {
   int result;
	public int countArrangement(int N) {
		if(N <= 0 )
			return 0;
		result = 0;
		int[] visited = new int[N+1];	// visited array to keep track of whether the element is already processed or not
		backtrack(N, 1, visited);
		return result;
	}
	private void backtrack(int N, int currPos, int[] visited){
		//base
		if(currPos > N)
			result++;
		//logic
		for(int i=1; i<=N; i++){
			if(visited[i] == 0 && (i%currPos == 0 || currPos%i == 0)){
				//action
				visited[i] = 1;
				//recurse
				backtrack(N, currPos+1, visited);
				//backtrack
				visited[i] = 0;
			}
		} 
	}
}