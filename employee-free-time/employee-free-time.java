/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;
​
    public Interval() {}
​
    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
​
//Tc: O(N log K)
//SC: O(K)
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> schedule.get(a[0]).get(a[1]).start - schedule.get(b[0]).get(b[1]).start);
        for(int i=0; i<schedule.size(); i++)
            pq.add(new int[] {i , 0});
        
        List<Interval> result = new ArrayList<>();
        int prev = schedule.get(pq.peek()[0]).get(pq.peek()[1]).start;
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            Interval interval = schedule.get(curr[0]).get(curr[1]);
            if(interval.start > prev)
                result.add(new Interval(prev, interval.start));
            
            prev = Math.max(prev, interval.end);
            
            if(schedule.get(curr[0]).size() > curr[1] + 1 )
                pq.add(new int[] {curr[0], curr[1] +1});
            
        }
        return result;
    }
}
