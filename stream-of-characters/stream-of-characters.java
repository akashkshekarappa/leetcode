//TC: O(N * M), where N is a number of input words, and M is the word length
//SC: O(N * M)
class StreamChecker {

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        
        private TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    private void insert(String word){
        TrieNode curr = root;
        //inserting back to front. i.e reverse suffix tree
        for(int i=word.length() -1; i>=0; i--){
            char c = word.charAt(i);
            if(curr.children[c -'a'] == null)
                curr.children[c -'a'] = new TrieNode();
            
            curr = curr.children[c -'a'];
        }
        curr.isEnd = true;
    }
    
    StringBuilder sb;
    
    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        for(String word: words)
            insert(word);
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode curr = root;
        
        for(int i=sb.length() -1; i>=0; i--){
            char c = sb.charAt(i);
            if(curr.children[c -'a'] == null)
                return false;
            
            curr = curr.children[c -'a'];
            
            if(curr.isEnd)
                return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */