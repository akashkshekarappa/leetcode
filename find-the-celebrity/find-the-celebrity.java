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
            if(knows(i, j) || !knows(j, i))
                return false;
        }
        return true;
    }
}