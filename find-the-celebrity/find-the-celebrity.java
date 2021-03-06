/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

//TC: O(n^2)
//SC: O(1)
public class Solution extends Relation {
    int numofPeople;
    public int findCelebrity(int n) {
        numofPeople = n;
        for(int i=0; i<n; i++){
            if(isCelebrity(i))
                return i;
        }
        return -1;
    }
    private boolean isCelebrity(int i){
        for(int j=0; j<numofPeople; j++){
            if(i == j)
                continue;
            if(knows(i, j) || !knows(j, i)) // if 1->1 is not there in given example[[[1,1,0],[0,1,0],[1,1,1]]], then return -1
                return false;
        }
        return true;
    }
}