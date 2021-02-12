//DFS
// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
class Solution {
    int color;
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if(image[sr][sc] == newColor)   //if newcolor is already equal to the {sr,sc}
			return image;   

		color = image[sr][sc]; 

		dfs(image, sr, sc, newColor);
		return image;
	}

	private void dfs(int[][] image, int sr, int sc, int newColor){
		//base
		if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color)
			return;

		//logic
		int dirs[][] = {{0,1}, {0,-1}, {-1,0}, {1,0}};

		image[sr][sc] = newColor;

		for(int[] dir: dirs){   //traversing in all four directions
			int r = sr + dir[0];
			int c = sc + dir[1];
			dfs(image, r, c, newColor);
		}
	}
}