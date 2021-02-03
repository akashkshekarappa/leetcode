//TC: O(n)
//SC: O(1)
class Solution {
    public int myAtoi(String s) {
        s = s.trim();//clears front and end whitespaces
        //edge case
        if(s.length() == 0)
            return 0;
        
        int result =0;
        int limit = Integer.MAX_VALUE / 10;//keeping infinity as max value / 10 to ensure that max range is not overshooted at any point
        char first = s.charAt(0);
        //return 0 if the 1st character is not a +, - or a digit
        if(first != '-' && first != '+' && !Character.isDigit(first))
            return 0;
        
        char sign = first == '-' ? '-' : '+';
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
               if(sign == '+'){
                //irrespective of value of current, result overshoots max value, so return integer max value
                   if(result > limit)
                       return Integer.MAX_VALUE;
                   else if(result == limit){     //return integer max value if current >= 7
                       if(c - '0' >= 7){
                           return Integer.MAX_VALUE;
                       }
                   }
               }
                else{
                //irrespective of value of current, result overshoots min value, so return integer min value
                    if(result > limit)
                        return Integer.MIN_VALUE;
                    else if(result == limit){
                        if(c - '0' >= 8){
                            return Integer.MIN_VALUE;
                        }
                    }
                } 
                result = result *10 + (c - '0');//update result
            }
            else if (i != 0){    //the first char can have '-' so if a char is found at any other index break
                break;
            }
        }
        return (sign == '+') ? result : -result;
    }
}