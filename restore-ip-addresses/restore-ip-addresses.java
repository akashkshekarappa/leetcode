//Backtracking
//TC: 
//SC:
class Solution {
    List<String> result;
    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        
        backtrack(s, new StringBuilder(), 0, 0);
        
        return result;
    }
    
    private void backtrack(String s, StringBuilder sb, int index, int level){
        if(index > s.length() || level > 4) //base case
            return;
        else if(index == s.length() && level == 4){//terminating condition
            result.add(sb.toString());
            return;
        }
        
        for(int i=1; i<=3; i++){
            if(index+i > s.length())
                break;
            
            int num = Integer.valueOf(s.substring(index, index+i));
            if(i==1 || i==2 && num >= 10 && num <= 99 || i==3 && num >= 100 && num <= 255){
                //action
                sb.append(num);
                
                if(level < 3)
                    sb.append(".");
                
                //recurse
                backtrack(s, sb, index+i, level+1);
                
                //backtrack
                if(level < 3)
