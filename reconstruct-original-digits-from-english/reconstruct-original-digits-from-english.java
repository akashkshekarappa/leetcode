//Using HashMap
//TC: 
//SC: 
class Solution {
    public String originalDigits(String s) {
        //base case
        if(s == null || s.length() == 0)
            return "";
        
        //building hashmap letter -> its frequency
        char[] count = new char[26 + (int) 'a'];
        for(char c: s.toCharArray())
            count[c]++;
        
        //building hashmap digit -> its frequency
        int[] out = new int[10];
        out[0] = count['z'];    //letter 'z' is present only in zero
        out[2] = count['w'];    //letter 'w' is present only in two
        out[4] = count['u'];    //letter 'u' is present only in four
        out[6] = count['x'];    //letter 'x' is present only in six
        out[8] = count['g'];    //letter 'g' is present only in eight
        
        out[3] = count['h'] - out[8];   //letter h is present only in three and eight
        out[5] = count['f'] - out[4];   //letter f is present only in five and four
        out[7] = count['s'] - out[6];   //letter s is present only in six and seven
        out[9] = count['i'] - out[5] - out[6] - out[8]; //letter i present in nine, five, six, eight
        out[1] = count['n'] - out[7] - 2*out[9];    //letter n is present in one, seven and nine
        
        //output string
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
            for(int j=0; j<out[i]; j++)
                sb.append(i);
        }
        
        return sb.toString();
    }
}