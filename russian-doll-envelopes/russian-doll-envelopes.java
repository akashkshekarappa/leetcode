class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        int[] arr = new int[envelopes.length];
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int len= 0;
        arr[len] = envelopes[0][1];
        len++;
        for(int i=1; i<arr.length; i++){
            //case1
            if(envelopes[i][1] > arr[len-1]){
                arr[len] = envelopes[i][1];
                len++;
            }
            else{
                //input is at its correct index, replace the just greater element
                int index = binarysearch(arr, 0, len, envelopes[i][1]);
                arr[index] = envelopes[i][1];
            }
        }
        return len;
    }
    private int binarysearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target)
                return mid;
            if(arr[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return low; // low ptr is always at the just greater element
    }
}