class Solution {
    HashMap<String, String> map = new HashMap<>(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    
    List<String> result;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.length() != 0)
            backtrack(digits, "");
        return result;
    }
    private void backtrack(String digits, String temp){
        // if there is no more digits to check
        if(digits.length() == 0)
            result.add(temp);
        
        else{// iterate over all letters which map the next available digit
            String num = digits.substring(0, 1);
            String letters =  map.get(num);
            for(int i=0; i<letters.length(); i++){
                String letter = map.get(num).substring(i, i+1);
                 // append the current letter to the combination and proceed to the next digits 
                
                backtrack(digits.substring(1), temp + letter);
            }
        }
    }
}
