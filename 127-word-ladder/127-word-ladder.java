// Time Complexity : O(nl) where n is number of words in dictionary and l is length of each word
// Space Complexity : O(nl)

class Pair{
    String word;
    int len;
    Pair(String word, int len){
        this.word = word;
        this.len = len;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            
            ListIterator<String> itr = wordList.listIterator();
            
            while(itr.hasNext()){
                String temp = itr.next();
                
                if(isAdjacency(curr.word, temp)){
                    itr.remove();
                    q.add(new Pair(temp, curr.len + 1));
                    
                    if(temp.equals(endWord))
                        return curr.len + 1;
                }
            }
        }
        return 0;
    }
    
    private boolean isAdjacency(String s1, String s2){
        int count = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                count++;
            
            if(count > 1)
                return false;
        }
        return count > 1 ? false : true;
    }
}