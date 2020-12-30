/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */
​
/*
​
Keep a buffer of size 4 as a class variable, call it prevBuf.
Whenever we call read(n), read from prevBuf first until all characters in prevBuf are consumed (to do this, we need 2 more int variables prevSize and prevIndex, which tracks the actual size of prevBuf and the index of next character to read from prevBuf). Then call read4 to read characters into prevBuf.
The code is quite clean I think.
*/
//TC: O(n)
//SC: O(1)
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    char[] prevBuf = new char[4];
    int prevSize = 0;
    int prevIndex = 0;
    
    public int read(char[] buf, int n) {
        int counter = 0;
        while(counter < n){
            if(prevIndex < prevSize){
                buf[counter++] = prevBuf[prevIndex++];
            }
            else{
                prevSize = read4(prevBuf);
                prevIndex = 0;
                if(prevSize == 0)
                    break;
            }
        }
        return counter;
    }
}
