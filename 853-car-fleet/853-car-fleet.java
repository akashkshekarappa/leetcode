//TC: O(n log n)
//SC: O(n)
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position == null || position.length == 0)
            return 0;
        
        TreeMap<Integer, Integer> tm = new TreeMap<>(Collections.reverseOrder());
        for(int i=0; i<position.length; i++){// sort by cars' position
            tm.put(position[i], speed[i]);
        }
        
        int fleets = 0;
        double slowest = 0;  // slowest fleet time to reach target.
        
        for(int pos : tm.keySet()){ // iterate starting from the fleet closest to the target.
            double time = (double) (target - pos) / tm.get(pos);    // time need for the car to reach the target.
            
            if(time <= slowest) // can catch up the slowest fleet ahead, merge into it.
                continue;
            
            fleets++;   // can NOT catch up, form a new fleet.
            
            slowest = time; // update slowest fleet time
        }
        return fleets;
    }
}