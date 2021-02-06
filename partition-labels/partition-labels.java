//Greedy using hashmap 
// Time Complexity : O(2n)
// Space Complexity : O(1)

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();  //to keep track of indices of each character
        int start = 0;
        int end = 0;
        for(int i=0; i<S.length(); i++){
            map.put(S.charAt(i), i);    //put character and corresponding indices
        }
        for(int i=0; i<S.length(); i++){
            end = Math.max(end, map.get(S.charAt(i)));  // to get the last indices of each character
            if(i == end){   // if at any time index is last index of character then add to resultant list
                result.add(end - start + 1);    
                start = end + 1;
            }
        }
        return result;
    }
}