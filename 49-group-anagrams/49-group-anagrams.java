//HashMap
//Here we will be using hashmap which will help us to map keys which contains the sorted characters and after that we will be searching for all the strings which contain those characters and make a link between them in the end we can return the elements having same characters.


//TC: O(n klogk),  n is length of words/ strings, K is length of strings of string 
//SC: O(n k)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();// hashmap to store sorted word as key, value as list of words matching with key
        for(int i=0; i<strs.length; i++){
            char[] c = strs[i].toCharArray();
            
            Arrays.sort(c);
            
            String sortedWords = String.valueOf(c);
            
            if(!map.containsKey(sortedWords))
                map.put(sortedWords, new ArrayList<>());
            
            map.get(sortedWords).add(strs[i]);
            
        //     for (String s : map.keySet()) {
        //     List<String> values = map.get(s);
        //     if (values.size() > 1) {
        //         System.out.print(values);
        //     }
        // }
        }
        return new ArrayList<>(map.values());
    }
}