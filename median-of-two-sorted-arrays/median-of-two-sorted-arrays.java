class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeArray = new int[nums1.length + nums2.length];
        int pt1= 0, pt2 = 0;
        int i=0;
        while(pt1 < nums1.length && pt2 < nums2.length){
            if(nums1[pt1] <= nums2[pt2]){
                mergeArray[i] = nums1[pt1];
                pt1++;
            }
            else{
                mergeArray[i] = nums2[pt2];
                pt2++;
            }
            i++;
        }
        while(pt1 < nums1.length){
            mergeArray[i] = nums1[pt1];
            pt1++;
            i++;
        }
        while(pt2 < nums2.length){
            mergeArray[i] = nums2[pt2];
            pt2++;
            i++;
        }
        int mid = mergeArray.length / 2;
        if(mergeArray.length % 2 == 0)
            return ((double)mergeArray[mid] + (double)mergeArray[mid-1]) /2;
        else
            return (double)mergeArray[mid];
​
    }
}
