/*
Increment left if the corresponding value is less than the next one.
Or decrement right if the corresponding value is less than the previous one.
Or return false otherwise, since none of the two pointers has moved; thus the mountain invariant does not hold.
*/
​
//TC: O(n)
//SC: O(1)
class Solution {
    public boolean validMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while(left < right){
            if(arr[left] < arr[left+1])
                left++;
            else if(arr[right] < arr[right-1])
                right--;
            else return false;
            
            if(left == right){
                return left != 0 && left != arr.length-1;
            }
        }
        return false;
    }
}
