/**Using Sliding window approach, where we store the starting index of every window in the HashMap
 * When the window contains the repeating character, we will update the index of that character
 * max length of such window is the required answer**/
//Time Complexity : O(n), n is length of string
//Space Complexity : O(1)
​
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int fast = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(fast < s.length()){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c)+1);    // update slow to the place after index where repeat begins
            }
            map.put(c, fast);   // storing character and its index
            max = Math.max(max, fast-slow+1);    // find max distance as max of previous max and distance between slow and fast
            fast++;
        }
        return max;
    }
}
