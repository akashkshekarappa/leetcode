//Custom sort
//TC: O(n logn)
//SC: O(n)
class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i=0; i<nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        
        Arrays.sort(strs, new LargestComparator());
        
        // If, after being sorted, the largest number is `0`, the entire number is zero
        if(strs[0].equals("0"))
            return "0";
        
        // Build largest number from sorted array.
        String largestNum = new String();
        for(String str: strs){
            largestNum += str;
        }
        return largestNum;
    }
}

class LargestComparator implements Comparator<String> {
    public int compare(String a, String b){
        String order1 = a + b;
        String order2 = b + a;
        return order2.compareTo(order1);
    }
}