//BFS: swap only pair at every step and use bfs to guaranteee shortest path
class Solution {
    public int kSimilarity(String A, String B) {
        if(A.equals(B))
            return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(A);
        visited.add(A);
        int result = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String curr = q.poll();
                if(curr.equals(B))
                    return result;
                
                int j=0;
                
                while(j < curr.length() && curr.charAt(j) == B.charAt(j))
                    j++;
                
                for(int k=j+1; k<curr.length(); k++){
                    if(curr.charAt(k) == B.charAt(j) && curr.charAt(k) != B.charAt(k)){
                        String next = swap(curr, j, k);
                        
                        if(!visited.contains(next)){
                            q.add(next);
                            visited.add(next);
                        }
                    }
                }
            }
            result++;
        }
        return result;
    }
    
    private String swap(String curr, int j, int k){
        char[] arr = curr.toCharArray();
        char temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
        
        return new String(arr);
    }
}