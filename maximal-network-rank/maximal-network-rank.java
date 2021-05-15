class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] noRoads = new int[n+1];   //number of road connected to city
        boolean[][] roadExists = new boolean[n][n];
        
        for(int[] city: roads){
            noRoads[city[0]]++; noRoads[city[1]]++; //increment the count of numbers of connected city
            
            //mark road exist, between two cities
            roadExists[city[0]][city[1]] = true;
            roadExists[city[1]][city[0]] = true;
        }        
        int max = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                //count total number of road connected to both city
                int rank = noRoads[i] + noRoads[j];
                
                //just decrement the rank, if both city connected
                if(roadExists[i][j])
                    rank--;
                
                max = Math.max(max, rank);
            }
        }
        return max;
    }
}