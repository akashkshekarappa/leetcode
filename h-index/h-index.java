class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        //bucket sort
        int[] buckets = new int[n+1];    // one more bucket to store values greater than n in citations array
        for(int i=0; i<n; i++){
            buckets[Math.min(citations[i], n)]++;   // increase the value bucket index = citations[i] , if //citations[i] > n then we incraese at last index of buckets array 
        }
        
        int sum=0;
        for(int i=buckets.length-1; i>=0; i--){ //iterate over the buckets array backwards
            sum+= buckets[i];   //finding the sum of bucket array( number of papers)
            if(sum >= i)    //when the sum crosses the index(citations)
                return i;   //return citations
        }
        return 0;
    }
}