//Backtracking
//TC: O(1)
//SC: O(1)
/*If one already put a dot that leaves only 3 possibilities for the next dot to be placed : after one digit, after two digits, or after three digits. The first dot has only 3 available slots as well.

That propagates constraints and helps to reduce a number of combinations to consider. Instead of 990990 combinations it's enough to check just  3×3×3=27. */
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
            if(i==1 || i==2 && num >= 10 && num <= 99 || i==3 && num >= 100 && num <= 255){//IP definition
                //action
                sb.append(num);
                
                if(level < 3)
                    sb.append(".");
                
                //recurse
                backtrack(s, sb, index+i, level+1);
                
                //backtrack
                if(level < 3)
                    sb.deleteCharAt(sb.length()-1);
                sb.delete(sb.length()-i, sb.length());
            }
        }
    }
}



/*
Definition of valid IP address:
1. The length of the ip without '.' should be equal to the length of s;
2. The digit order of ip should be same as the digit order of s;
3. Each part separated by the '.' should not start with '0' except only '0';
4. Each part separared by the '.' should not larger than 255;
*/