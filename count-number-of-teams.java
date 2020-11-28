//Optimized
//TC: O(n^2)
//SC: O(1)
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        
        for(int j=0; j<n; j++){
            int leftSmaller = 0, rightLarger = 0;
            int leftLarger = 0, rightSmaller = 0;
            for(int i=0; i<j; i++){
                if(rating[i] < rating[j])
                    leftSmaller++;
                else if(rating[i] > rating[j])
                    leftLarger++;
            }
            
            for(int k=j+1; k<n; k++){
                if(rating[j] < rating[k])
                    rightLarger++;
                else if(rating[j] > rating[k])
                    rightSmaller++;
            }
            
            count+= leftSmaller * rightLarger + leftLarger * rightSmaller;
        }
        return count;
    }
}
