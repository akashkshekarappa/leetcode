//TC: O(n)
//SC: O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        //edge case
        if(tasks == null || tasks.length == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        int maxFreq = 0;
        // map with count of each task and keeping track of max frequency of task
        for(char task: tasks){
            int count = map.getOrDefault(task, 0) + 1;
            maxFreq = Math.max(maxFreq, count);
            map.put(task, count);
        }
        //iterate over map and if task is equal to maxFreq, then increment maxCount
        for(char c: map.keySet()){
            if(map.get(c) == maxFreq)
                maxCount++;
        }
        
//         int partitions = maxFreq - 1;
//         int empty = partitions * (n - maxCount + 1);
//         int pending = tasks.length - (maxFreq * maxCount);
//         int idle = Math.max(0, empty - pending);
        
//         return idle + tasks.length;
        
        return Math.max(tasks.length, (maxFreq - 1) * (n+1) + maxCount);
    }
}