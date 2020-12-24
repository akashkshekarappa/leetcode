class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];   //to keep track of the no of dependencies a course(represented by index) has
​
        Map<Integer, List<Integer>> map = new HashMap<>();  // to store depended course on course
​
        for(int edge[]: prerequisites){
            indegree[edge[0]]++;    // for first index increment its indegree as it is dependent
            if(!map.containsKey(edge[1]))   // put the subject it is dependent on as key
                map.put(edge[1], new ArrayList<>());
​
            map.get(edge[1]).add(edge[0]);  // add the course that is dependent in the array list so that we can use it while processing the courses in queue
        }
​
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0)    // finding all the courses that are independent
                q.add(i);
        }
​
        while(!q.isEmpty()) {
            int curr = q.poll();    // remove from queue
            List<Integer> child = map.get(curr);    // get the courses dependent on curr
            if(child != null){
                for(int i: child){
                    indegree[i]--;  // reducing indegree as the course they are dependent on has been completed
​
                    if(indegree[i] == 0)    // if the value becomes zero i.e it is independent
                        q.add(i);
                }
            }
        }
​
        for(int i: indegree) {   // check if at any course, the indegree is greater than 0
            if(i > 0)
                return false;
        }
        return true;
    }
}
