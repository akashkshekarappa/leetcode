//Sliding window
//TC: O(n)
//SC: O(1)
class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        int slow = 0;
        for(int fast=0; fast<S.length(); fast++){
            while(set.contains(S.charAt(fast)))
                set.remove(S.charAt(slow++));
            
            set.add(S.charAt(fast));
            
            if(fast - slow + 1 == K){
                result++;
                set.remove(S.charAt(slow++));
            }
        }
        return result;
    }
}