/**Store all the characters of the s string to a HashMap with their frequency
 * For each character in order, append all the characters occurrences to the String Builder 
 * Remove the keys, once the count hits zero. At the end for any remaining entries in the HashMap, append it to the string Builder and return the String**/
//Time Complexity : O(m+n),length of 2 strings
//Space Complexity : O(1)
class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(int i=0; i<order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count > 0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        for(char key: map.keySet()){
            int count = map.get(key);
            while(count > 0){
                sb.append(key);
                count--;
            }
        }
        return sb.toString();
    }
}