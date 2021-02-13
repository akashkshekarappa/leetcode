//TC: O(n)
//SC: O(1)
class Solution {
    public int firstUniqChar(String s) {
         // build hash map : character and how often it appears
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        //finding the index
        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}

/**
public class Solution {
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
*/