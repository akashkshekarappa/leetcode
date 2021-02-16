//Two Pointer
//TC: O(n)
//SC: O(1)

/* Using two pointers, low (pointing to first element) and high (pointing to last element). maxarea to store the maximum area obtained.
 * The area between two lines is the max of product of the minimum of the two heights and the distance between them.
 * if the height of low pointer is less than high pointer, we increment low pointer, else decrement high*/

class Solution {
    public int maxArea(int[] height) {
        //edge case
        if(height == null || height.length == 0)
            return 0;
        int maxArea = 0;
        int low = 0;
        int high = height.length-1;
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
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }
}

/*
public class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }
}
*/