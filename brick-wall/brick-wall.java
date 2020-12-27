//TC: O(n),We traverse over the complete bricks only once. n is the total number of bricks in a wall.
//SC: O(m),mapmap will contain atmost m entries, where m refers to the width of the wall.
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> freqmap = new HashMap<>();
        int prefixSum = 0;
        
        for(List<Integer> row: wall){
            prefixSum = 0;
            for(int i=0; i<row.size()-1; i++){
                prefixSum+= row.get(i);
                freqmap.put(prefixSum, freqmap.getOrDefault(prefixSum,0)+1);
            }
        }
        
        int result = wall.size();
        for(int key: freqmap.keySet()){
            result = Math.min(result, wall.size() - freqmap.get(key));
        }
        
        return result;
    }
}
​
/*
Basic idea is in each row, we need to know if a line falls at the edge of a brick or goes through any brick. If we compute prefix sum for each row, we can say if a line going through any brick or falls at the edge of a brick - how? "falls at the edge of a brick" meaning the length of that brick must be part of prefix sum for all such rows.
​
So all we need is a brick whose length ends at the same point across maximum rows.
So we just record prefix sum frequency and choose the maximum. But for the answer, we need how many rows are touched. So total# of rows - max rows not touched.
*/
