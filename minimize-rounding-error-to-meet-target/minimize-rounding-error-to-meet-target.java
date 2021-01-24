//Priority queue + Greedy Approach
//TC: O(n logn)
//SC: O(k)
class Solution {
    public String minimizeError(String[] prices, int target) {
        float result = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        
        for(String p: prices){
            float currValue = Float.valueOf(p);
            
            double floor = Math.floor(currValue);
            double ceiling = Math.ceil(currValue);
            
            if(floor != ceiling)
                pq.add((ceiling - currValue)-(currValue - floor));
            
            result += currValue - floor;
            target -= floor;
        }
        
        if(target > pq.size() || target < 0)
            return "-1";
        while(target > 0){
            target --;
            result += pq.poll();
        }
        
        return String.format("%.3f", result);
    }
}
​
// 1. we remove all integer value. Target-Val;
// 2. we use floor value. Target- floor. Then for each value,then we will have 0(floor) or 1(ceiling)
// 3. in the meantime, target<0 || countAllones<target. we will not get solution
// 4. Used greedy strategy, first of all, find all enough ceilings with minmium difference until target == 0.
// 5. then we may count all difference with floor value.
