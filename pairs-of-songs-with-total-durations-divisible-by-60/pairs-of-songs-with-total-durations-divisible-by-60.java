//HashMap
//TC: O(n)
//SC: O(1)
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int reminder[] = new int[60];
        for(int i=0; i<time.length; i++){
            if(time[i] % 60 == 0)// check if a%60==0 && b%60==0
                count += reminder[0];
            else                    // check if a%60+b%60==60
                count += reminder[60 - time[i]%60];
            
            reminder[time[i]%60]++;   // reminder to update the reminders
        }
        return count;
    }
}