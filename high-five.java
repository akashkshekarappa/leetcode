//TC: O(n logn)
class Solution {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int[] item: items){
            int student = item[0];
            int score = item[1];
            
            if(!map.containsKey(student))
                map.put(student, new PriorityQueue<>());
            
            PriorityQueue<Integer> pq = map.get(student);
            
            if(pq.size() < 5){
                pq.add(score);
            }
            else if(pq.peek() < score){
                pq.poll();
                pq.add(score);
            }
        }
        
        
        int index = 0;
        int[][] result = new int[map.size()][2];
        
        for(int id : map.keySet()){
            result[index][0] = id;
            PriorityQueue<Integer> pq = map.get(id);
            int sum = 0;
            int size = pq.size();
           
            while(!pq.isEmpty()){
               sum+= pq.poll();
            }
         
            result[index][1] = sum/size;
           
            index++;
        }
        return result;
    }
}
