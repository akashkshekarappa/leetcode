//Gray code: A Gray code is an encoding of numbers so that adjacent numbers have a single digit differing by 1. The term Gray code is often used to refer to a "reflected" code, or more specifically still, the binary reflected Gray code. ... Take the Gray code 0, 1
//Time complexity: O(2 ^ N)
//Space complexity: O(2 ^ N)
class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i< 1 << n; i++)
            result.add(start ^ i ^ i >> 1);
        
        return result;
    }
}