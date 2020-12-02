//TC: O(n)
//C: O(1)
class Solution {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for(int start=0; start<a.length; start+= 2 * k){
            int i = start;
            int j = Math.min(start + k-1, a.length-1);
            
            while(i < j){
                char temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        return new String(a);
    }
}
​
