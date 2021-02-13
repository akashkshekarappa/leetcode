//BFS + Priority queue
//TC: O(n logn)
//SC: O(n)
class Solution {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int maximumMinimumPath(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        boolean[][] visited = new boolean[m][n];
// in the BFS approach, for each step, we are interested in getting the maximum min that we have seen so far, thus we reverse the ordering in the pq
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[2] - a[2]);
        pq.add(new int[] {0, 0 , A[0][0]});
        //BFS
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0]; int c = curr[1];
            if(r == m-1 && c == n-1)
                return curr[2];
            
            visited[r][c] = true;
            
            for(int[] d: dirs){
                int row = r + d[0];
                int col = c + d[1];
                if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col])
                    continue;
                 // we are keeping track of the min element that we have seen until now
                pq.add(new int[] {row, col, Math.min(curr[2], A[row][col])});
            }
        }
        return -1;
    }
}