//Approach :Right-to-Left Pass
//TC: O(1)
//SC: O(1)
class Solution {
    
    static HashMap<String, Integer> map = new HashMap<>();
        static{
            map.put("M", 1000);
            map.put("D", 500);
            map.put("C", 100);
            map.put("L", 50);
            map.put("X", 10);
            map.put("V", 5);
            map.put("I", 1);
        }
    
    public int romanToInt(String s) {
        String lastSymbol = s.substring(s.length()-1);
        int lastValue = map.get(lastSymbol);
        
        int total = lastValue;
        
        for(int i=s.length()-2; i>=0; i--){
            String currrentSymbol = s.substring(i, i+1);
            int currentValue = map.get(currrentSymbol);
            
            if(currentValue < lastValue){
                total = total - currentValue;
            }
            else{
                total = total + currentValue;
            }
            lastValue = currentValue;
        }
        return total;
    }
}
