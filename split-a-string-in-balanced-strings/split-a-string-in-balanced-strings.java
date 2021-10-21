class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int left = 0;
        int right = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'L')
                left++;
            if(c == 'R')
                right++;
            
            if(left == right)
                count++;
        }
        return count;
    }
}