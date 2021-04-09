//start filling up from left and right complementary values (so if we insert 1 from left, insert -1 from right, then insert 2 from left and insert -2 from right and so on) :
class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int left = 0;
        int right = n-1;
        int start = 1;
        while(left < right){
            result[left++] = start;
            result[right--] = -start;
            start++;
        }
        return result;
    }
}