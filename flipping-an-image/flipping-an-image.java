/*
For each row, use two pointers. One is going forward and the other is going backward.
(1). If the two elements are the same, then make a slight change like this 0 -> 1 or 1 -> 0.
(2). If the two elements are different, DON'T do anything. Just let it go.

Only scan the whole matrix once.
*/

//TC: O(n)
//S: O(1)
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0; i<image.length; i++){
            int low = 0;
            int high = image[0].length-1;
            
            while(low <= high){
                if(image[i][low] == image[i][high]){
                    image[i][low] = 1 - image[i][low];
                    image[i][high] = image[i][low];
                }
                low++;
                high--;
            }
        }
        return image;
    }
}