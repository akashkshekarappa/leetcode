//Priority Queue
//TC: O(log n)
//SC: O(log n)
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);   //max heap
        pq.addAll(Arrays.asList(boxTypes));
        
        int unitCount = 0;
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int boxCount = Math.min(truckSize, curr[0]);
            unitCount+= boxCount * curr[1];
            
            truckSize-= boxCount;
            if(truckSize == 0)
                break;
        }
        return unitCount;
    }
}