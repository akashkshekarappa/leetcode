/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */
​
//Approach 2: Speed Up: No Internal Buffer
//TC: O(n)
//S: O(1)
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int total = 0;
        char[] temp = new char[4];
        
        while(true){
            
            int count = read4(temp);
            for(int i = 0; i < count; i++){
                
                if (total == n)
                    return total;
                
                buf[total] = temp[i];
                total++;
​
            }
            
            if (count <4)
                return total;  
        }
    }
}
​
​
