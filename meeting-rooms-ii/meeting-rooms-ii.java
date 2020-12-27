//Time Complexity : O(m*n log m*n)=> O(NlogN), length of intervals
//Space Complexity :O(m*n)=> O(N), size of heap
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //base case
        if(intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]); //sort based on start time
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= pq.peek())// If start time > prev meetings end time, not need an extra meeting room
                pq.poll();
            
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}
