//TC: O(n + m) in the average case and O(n*m) in worst case
//SC: O(n + m)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int i=0; i<nums1.length; i++)
            set1.add(nums1[i]);
        Set<Integer> set2 = new HashSet<>();
        for(int j=0; j<nums2.length; j++)
            set2.add(nums2[j]);
        
        set1.retainAll(set2);
        int[] arr = new int[set1.size()];
        int i = 0;
        for (int num : set1) {
            arr[i++] = num;
        }
        return arr;
    }
}
