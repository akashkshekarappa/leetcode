//TC : O(n^2)
//SC: O(n)
//we start with the first student (first row), i=0. set visitied[i] =0
//initialize noOfcircles = 1;
//move to next student j, for which M[i][j] = Y, set visitied[j] = 1
//recursively find the friends of j and mark them visited too till all students that can be reached from i=0 are covered. these will form 1 friend circle
//once all friends of student 1 are traversed, we move to next unvisited student and increase noOfcircles by 1
//repeat the above steps till all the students are visited
//return noOfiCircles
class Solution {
    public int findCircleNum(int[][] M) {
       if(M == null || M.length < 1)// edge case
           return 0;
        int noOfCircles = 0;
        int[] visited = new int[M.length];
         
        for(int i=0; i<M.length; i++){
            if(visited[i] == 0){
                noOfCircles++;
                dfs(M, visited, i);
            }
        }
        return noOfCircles;
    }
    
    
    private void dfs(int[][] M, int[] visited, int i){
        for(int j=0; j<M.length; j++){
            if(M[i][j] ==1 && visited[j] == 0){
                visited[i] = 1;
                dfs(M, visited, j);
            }
        }
    }
}