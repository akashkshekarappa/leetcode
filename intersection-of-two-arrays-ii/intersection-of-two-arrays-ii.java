//Time Complexity :O(n + m), n and m are size of given two arrays
//Space Complexity :O(n), first array is stored in hashmap with its frequency
​
/**Using Hashmap, store all the elements with the key and the frequency of numbers
 * Once the number of occurrences hits zero while traversing through the second array, remove it from the hash map
 * all intersected elements will be in a stored in a list then*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];
​
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
​
        for(int num : nums2){
            if(map.containsKey(num)){
                list.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
        int result[] = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            result[i] = list.get(i);
​
        return result;
    }
}
