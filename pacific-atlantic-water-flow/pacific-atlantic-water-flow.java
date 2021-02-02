//DFS
//TC: O(m * n)
//SC: O(m * n)
class Solution {
    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return result;   //base case
        int m = matrix.length; int n = matrix[0].length;
        
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        //top and bottom
        for(int col=0; col<n; col++){
            dfs(matrix, 0, col, Integer.MIN_VALUE, pacific);
            dfs(matrix, m-1, col, Integer.MIN_VALUE, atlantic);
        }
        
        //left and right
        for(int row=0; row<m; row++){
            dfs(matrix, row, 0,Integer.MIN_VALUE, pacific);
            dfs(matrix, row, n-1,Integer.MIN_VALUE, atlantic);
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    result.add(curr);
                }
            }
        }
        return result;
    }
    
    private void dfs(int[][] matrix, int row, int col, int preHeight, boolean[][] ocean){
        if(row <0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] < preHeight || ocean[row][col]) return;
        
        
        ocean[row][col] = true;
        for(int[] dir: dirs){
            int r = dir[0] + row;
            int c = dir[1] + col; 
            dfs(matrix, r, c, matrix[row][col], ocean);
        }
    }
}