class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m-1;
        int pointer2 = n-1;
        int index = m+n-1; // all the elements after this index are sorted
        while(pointer2 >=0 && pointer1 >=0){
            if(nums2[pointer2] > nums1[pointer1]){
                //place the higher number to the index postion
                nums1[index] = nums2[pointer2];
                index--;
                pointer2--;
            }
            else{   // nums1 is greater or equal to nums2
                nums1[index] = nums1[pointer1];
                index--;
                pointer1--;
            }
        }
        
        while(pointer2 >=0){ // if pointer 2 out of array, then copy all elements from nums2 to nums1
            nums1[index] = nums2[pointer2];
            pointer2--;
            index--;
        }
    }
}
