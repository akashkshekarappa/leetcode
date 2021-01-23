//DFS Approach
//TC:
//SC:
class Solution {
    public int maxLength(List<String> arr) {
        return helper(arr, 0, "");
    }
    private int helper(List<String> arr, int index, String curr){
        if(index == arr.size())
            return curr.length();
        
        int result = curr.length();
        for(int i=index; i<arr.size(); i++){
            String str = curr + arr.get(i);
            
            if(isUnique(str))
                result = Math.max(result, helper(arr, i+1, str));
        }
        return result;
    }
    private boolean isUnique(String s){
        Set<Character> set = new HashSet<>();
        for(char c: s.toCharArray()){
            if(!set.add(c))
                return false;
        }
        return true;
    }
}
