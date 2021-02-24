class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i]) == false)
                map.put(arr[i], new HashSet<>());
            map.get(arr[i]).add(i);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        int step =0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int curr = q.poll();
                if(curr == arr.length-1)
                    return step;
                
                if(curr-1 >= 0 && visited[curr-1] == false){
                    q.add(curr-1);
                    visited[curr-1] = true;
                }
                
                if(curr +1 < arr.length && visited[curr+1] == false){
                    q.add(curr +1);
                    visited[curr+1] = true;
                }
                if(map.containsKey(arr[curr]) == false)
                    continue;
                
                for(Integer nextIndex: map.get(arr[curr])){
                    if(nextIndex != curr && visited[nextIndex] == false){
                        q.add(nextIndex);
                        visited[nextIndex] = true;
                    }
                }
                map.get(arr[curr]).clear();
            }
            step++;
        }
        return -1;
    }
}