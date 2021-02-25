//TC: O(S + T)
//SC: O(S + T)
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0)
            return "";
        
        HashMap<Character, Integer> mapT = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        int required = mapT.size();
        int left = 0, right = 0;
        int formed = 0;
        
        HashMap<Character, Integer> mapS = new HashMap<>();
        int[] ans = {-1, 0, 0};
        while(right < s.length()){
            char c = s.charAt(right);
            mapS.put(c, mapS.getOrDefault(c, 0) +1);
            
            if(mapT.containsKey(c) && mapS.get(c).intValue() == mapT.get(c).intValue())
                formed++;
            
            while(left <= right && formed == required){
                c = s.charAt(left);
                if(ans[0] == -1 || right - left +1 < ans[0]){
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                c  = s.charAt(left);
                mapS.put(c, mapS.get(c) -1);
                
                if(mapT.containsKey(c) && mapS.get(c).intValue() < mapT.get(c).intValue())
                    formed--;
                
                left++;
            }
            right++;

        }  
        if(ans[0] == -1)
            return "";
        else
            return s.substring(ans[1], ans[2] + 1);
        
    }
}