//TC: O(n)
//SC: O(1)
class Solution {
    public int[] replaceElements(int[] arr) {
        int maxSoFar = -1;
        for(int i=arr.length-1; i>=0; i--){
            int newMaxSoFar = Math.max(arr[i], maxSoFar);
            arr[i] = maxSoFar;
            maxSoFar = newMaxSoFar;
        }
        return arr;
    }
}