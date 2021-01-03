/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//BFS
//Time Complexity :O(n), where n is the number of total employees.
//Space Complexity : O(n), where n is the number of total employees.
class Solution {
    public int getImportance(List<Employee> employees, int id) {
     HashMap<Integer, Employee> map = new HashMap<>();
​
        for(Employee e : employees) // insert emp id and their object in map so that we dont have to traverse the employee list again and again
            map.put(e.id, e);
​
        Queue<Integer> q = new LinkedList<>();
        q.add(id);  // adding id for which importance has to be found
​
        int result = 0;
        while(!q.isEmpty()){
            int curr = q.poll();    //get latest employee out of queue
​
            Employee e = map.get(curr); // get the employee details
            result += e.importance; // add importance to the total result
​
            for(int subId : e.subordinates) // iterate on the subordinates of the curr employee and add them to queue
                q.add(subId);
        }
        return result;   
    }
}
