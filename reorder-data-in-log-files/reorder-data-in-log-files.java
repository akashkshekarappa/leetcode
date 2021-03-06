//TC:O(n logn), SC: O(1)
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length == 0)    //edge case
            return new String[0];
        
        Arrays.sort(logs, (String a, String b) ->{
            //eg - split "dig1 8 1 5 1" into ["dig1", "8 1 5 1"]
            String[] aEq = a.split(" ", 2);//split string based on whitespace (1st whitespace) into 2 parts 
            String[] bEq = b.split(" ", 2);
            
            //both are digits
            //checking based on 1st index of equivalent[], if the 1st char at 1st index is number, then log is a number
            if(Character.isDigit(aEq[1].charAt(0)) && Character.isDigit(bEq[1].charAt(0)))
                return 0;//insertion order
            
            else if(!Character.isDigit(aEq[1].charAt(0)) && !Character.isDigit(bEq[1].charAt(0))){ //both are articles
                if(aEq[1].equals(bEq[1]))    //both the descriptions of articles are same so return based on identifier
                    return -1;//a should come before b
                
                else{ //lexicographic order as descriptions are different
                    int order = aEq[1].compareTo(bEq[1]);
                    if(order < 0)
                        return -1;//a is smaller, a should come before b
                    else
                        return 1; //a is larger, b should come before a
                } 
            }
            else{//one digit one article
                if(Character.isDigit(aEq[1].charAt(0)))
                    return 1;//b should come before a
                else 
                    return -1;//a should come before b
            }
        });
        return logs;
    }
}
