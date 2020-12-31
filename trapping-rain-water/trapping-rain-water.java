//Two pointer Approach
//TC: O(n)
//SC: O(1)
class Solution {
    public int trap(int[] height) {
        //edge case
        if(height == null || height.length == 0)
            return 0;
        int left = 0;
        int right = height.length -1;
        int leftwall = 0;
        int rightwall = 0;
        int result = 0;
        
        while(left <= right){
            //which side to process
            if(leftwall <= rightwall){  //process left side
                if(height[left] < leftwall){    //then i can form a trap on left side
                    result+= leftwall - height[left];   
                }
                else{
                    leftwall = height[left];
                }
                left++; //after processing left side
            }
            else{   //process on right side
                if(height[right] < rightwall){
                    result+= rightwall - height[right];
                }
                else{
                    rightwall = height[right];
                }
                right--;    //process on right side, so we decrease
            }
        }
        return result;
    }
}
