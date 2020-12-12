//TC: O(n)
//SC: O()
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int max = 0;
        Map<Integer, Integer> freqmap = new HashMap<>();
        int prefixSum = 0;
        
        for(List<Integer> row: wall){
            prefixSum = 0;
            for(int n : row){
                prefixSum+= n;
                freqmap.put(prefixSum, freqmap.getOrDefault(prefixSum,0)+1);
            }
        }
        
        for(int key: freqmap.keySet()){
            
            if(key == prefixSum)
                continue;
            max = Math.max(max, freqmap.get(key));
        }
        
        return wall.size() - max;
    }
}
​
/*
Basic idea is in each row, we need to know if a line falls at the edge of a brick or goes through any brick. If we compute prefix sum for each row, we can say if a line going through any brick or falls at the edge of a brick - how? "falls at the edge of a brick" meaning the length of that brick must be part of prefix sum for all such rows.
​
So all we need is a brick whose length ends at the same point across maximum rows.
So we just record prefix sum frequency and choose the maximum. But for the answer, we need how many rows are touched. So total# of rows - max rows not touched.
Also note that we shouldn't consider the line passing at the edge of all rows, that is why
if(key == pre) continue;
*/
