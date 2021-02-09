//TC: O(n logk)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][];
        int count = 0;
        
        if(points == null || points.length == 0)    //base case
            return result;
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(K, (a,b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        
        for(int[] point: points){
            maxHeap.add(point);
            
            if(maxHeap.size() > K)
                maxHeap.poll();
        }
        
        while(!maxHeap.isEmpty()){
            result[count++] = maxHeap.poll();
        }
        return result;
    }
}