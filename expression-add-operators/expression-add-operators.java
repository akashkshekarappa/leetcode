//Backtracking
//TC: O(n * 4^n)
//SC: O(n)
class Solution {
   List<String> result;
    int targ;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        targ = target;
        if(num == null || num.length() == 0)
            return result;
        backtrack(num, new StringBuilder(), 0, 0, 0);
        return result;
    }
    private void backtrack(String num, StringBuilder sb, long calc, long tail, int index){
        //base
        if(index == num.length())
        {
            if(targ==calc)
                result.add(sb.toString());
            return;  
        }
        //logic
        for(int i=index; i<num.length(); i++){
            //preceding zero case
            if(num.charAt(index) == '0' && index != i)
                break;
            long curr = Long.parseLong(num.substring(index, i+1));
            int len = sb.toString().length();
            if(index == 0){
                sb.append(curr);    //action
                backtrack(num, sb, curr, curr, i+1);    //recurse
                sb.setLength(len);  //backtrack
            }else{
                sb.append("+"); //action
                sb.append(curr);    //action
                backtrack(num, sb, calc + curr, curr, i+1); //recurse
                sb.setLength(len);//backtrack
                
                sb.append("-"); //action
                sb.append(curr);    //action
                backtrack(num, sb, calc - curr, -curr, i+1);    //recurse
                sb.setLength(len);//backtrack
                
                sb.append("*"); //action
                sb.append(curr);    //action
                backtrack(num, sb, calc - tail + tail * curr, tail * curr, i+1);    //recurse
                sb.setLength(len);//backtrack
            }
        }
    }
}