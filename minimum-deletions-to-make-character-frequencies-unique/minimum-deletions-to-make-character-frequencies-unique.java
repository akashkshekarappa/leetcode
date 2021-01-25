//Greedy Approach
//TC: O(n)
//SC: O(n)
class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) +1);
        
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for(char c : map.keySet()){
            int key = map.get(c);
            while(set.contains(key)){
                key--;
                result++;
            }
            if(key != 0)
                set.add(key);
        }
        return result;
    }
}
