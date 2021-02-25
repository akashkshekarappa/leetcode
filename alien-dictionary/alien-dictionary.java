class Solution {
    HashMap<Character, HashSet<Character>> map; // to over repeat chars to put in map
    int[] indegrees;
    public String alienOrder(String[] words) {
        map = new HashMap<>();
        indegrees = new int[26];  //no. of chars, only lower case
        buildGraph(words);  //build the graph
        
        //bfs
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for(char c : map.keySet()){
            if(indegrees[c - 'a'] == 0)
                q.add(c);
        }
        //processing bfs
        while(!q.isEmpty()){
            char curr = q.poll();
            sb.append(curr);
            for(char e: map.get(curr)){
                //reduce the indegree, if indegree of my edge becomes zero, add to queue
                indegrees[e - 'a']--;
                if(indegrees[e - 'a'] == 0)
                    q.add(e);
            }
        }
        if(sb.length() != map.size())
            return "";
        
        return sb.toString();
    }
    private void buildGraph(String[] words){
        for(String word: words){
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(!map.containsKey(c))
                    map.put(c, new HashSet<>());
            }
        }
        for(int i=0; i<words.length-1; i++){
            String first = words[i];
            String second = words[i+1];
        
            int m = first.length(); int n = second.length();
            
            if(m > n && first.startsWith(second))
                map.clear();
            
            for(int j=0; j<m && j<n; j++){
                char out = first.charAt(j);  char in = second.charAt(j);
                
                if(out != in){
                    if(!map.get(out).contains(in)){
                        map.get(out).add(in);
                        indegrees[in - 'a']++;
                    }
                    break;
                }
            }
        }
    }
}