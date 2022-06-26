//Two Pointer
//TC: O(n)
//SC: O(1)

/* Using two pointers, low (pointing to first element) and high (pointing to last element). maxarea to store the maximum area obtained.
 * The area between two lines is the max of product of the minimum of the two heights and the distance between them.
 * if the height of low pointer is less than high pointer, we increment low pointer, else decrement high*/
class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0)    //base case
            return 0;
        int maxArea = 0;
        int low = 0;
        int high = height.length - 1;
        while(low < high){
            int currentArea = 0;
            if(height[low] < height[high]){
                currentArea = height[low] * (high-low);
                low++;
            }
            else{
                currentArea = height[high] * (high-low);
                high--;
            }
            maxArea = Math.max(currentArea, maxArea);
        }
        return maxArea;
    }
}
// //Brute Force: Here we will be trying to figure out the maximum amount of water by findingall the possible combinations of heights and then storing the maximum water which we can get.
// class Solution {
//     public int maxArea(int[] height) {
//         int maxArea = 0;
//         for(int i=0; i<height.length; i++){
//             for(int j=i+1; j<height.length; j++){
//                 maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j-i));
//             }
//         }
//         return maxArea;
//     }
// }