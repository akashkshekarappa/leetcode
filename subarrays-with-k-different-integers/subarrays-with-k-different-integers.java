//Sliding window
//TC: O(n)
//SC: O(K)
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMost(A, K) - atMost(A, K-1);
    }
    private int atMost(int[]A, int K){
        int i =0;
        int result =0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int j=0; j<A.length; j++){
            if(map.getOrDefault(A[j], 0) == 0)
                K--;
            map.put(A[j], map.getOrDefault(A[j], 0) +1);
            
            while(K < 0){
                map.put(A[i], map.get(A[i]) -1);
                if(map.get(A[i]) == 0)
                   K++;
                
                i++;
            }
            result += j-i+1;
        }
        return result;
    }
}


/*
Step 1: Take array as: A = [1, 2, 1*, 2*, 3].
Take the next occurrence of the element with a character(here asterisk *) to show that event though it is identical but not same as it has different index in array.

Step 2: Write all subarrays possible with lengths = {1,2,...n} for the valid subarrays: {[1], [1,2], [1,2,1*], [1,2,1*,2*], [2*,3]}. They would have each n*(n+1)/2 elements got from 1+2+...+n subarrays, where n is length of subarray. Like [1,2] = {[1], [2], [1,2]}.

Step 3: Cut the subarrays appeared previously, here those asterisk * would come to aid as we have to cut same subarrays i.e 1 is not equal to 1*. It would come out to be equal to length of the subarray in every case. That's j-i+1 in every case of subarray.

Step 4: Thus we would add all of them like @lee215 did and return.

Now, this would do exactly(K) = atMost(K) - atMost(K-1)

Fun Fact: Where did the [] or null set go, as we're talking about atmost ? It exists and should be returned from the atmost(K) function but even if its returned it would get subtracted from the one in atmost(K-1), so in this case it doesn't matter handling that. However, it shouldn't be overlooked.

Original question {exact(k)} doesn't distinguish between 1 and 1*. But what if it did?
*/