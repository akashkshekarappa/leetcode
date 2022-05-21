//Here we will be using 2 pointers starting both the pointers at the last index of both the arrays and then start comparing the 2 values of the respective arrays. This way we will keep on putting the values in the sorted order and in the end whatever are going to be the remaining values we are simply going to append them as it is.
//TC: O(n + m)
//SC: O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m -1;
        int pointer2 = n-1;
        int index = m + n -1;   // all the elements after this index are sorted
        
        while(pointer2 >= 0 && pointer1 >= 0){
            if(nums1[pointer1] > nums2[pointer2]){
                nums1[index] = nums1[pointer1]; //place the higher number to the index postion	
                index--;
                pointer1--;
            }
            else{
                nums1[index] = nums2[pointer2];
                index--;
                pointer2--;
            }
        }
        
        while(pointer2 >= 0){  // if pointer 2 out of array, then copy all elements from nums2 to nums1
            nums1[index] = nums2[pointer2];
            index--;
            pointer2--;
        }
    }
}