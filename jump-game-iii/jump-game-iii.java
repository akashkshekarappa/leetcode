//BFS Approach
//TC: O(N), visiting every index at most once
//SC: O(N), storing indexes in queue
class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            if(arr[curr] == 0)  //check if reach zero
                return true;
            if(arr[curr] < 0)
                continue;
            
            if(curr + arr[curr] < arr.length)   //check available next steps
                q.add(curr + arr[curr]);
            if(curr - arr[curr] >= 0)
                q.add(curr - arr[curr]);
            
            arr[curr] = -arr[curr]; //marking visited
        }
        return false;
    }
}