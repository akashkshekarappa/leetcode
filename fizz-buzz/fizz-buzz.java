//Hashmap
//TC: O(n)
//SC: O(1)
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        
        Map<Integer, String> map = new HashMap<>(){{
            put(3, "Fizz");
            put(5, "Buzz");
        }};
        
        for(int i=1; i<=n; i++){
            String curr = "";
            for(Integer key: map.keySet()){
                // If the num is divisible by key,then add the corresponding string mapping to current numAnsStr
                if(i % key == 0)
                    curr+= map.get(key);
            }
            if(curr.equals(""))
                curr+= Integer.toString(i); // Not divisible by 3 or 5, add the number
            
            result.add(curr);// Append the current answer str to the ans list
        }
        return result;
    }
}