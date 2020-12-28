class WordDictionary {
​
    class TrieNode{
        TrieNode children[];
        boolean isEnd;
        
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {  //TC: O(m), SC: O(m)
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();
            
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {//TC: O(m), SC: O(m)
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chars, int k, TrieNode curr){
        if(k == chars.length)
            return curr.isEnd;
        
        if(chars[k] == '.'){
            for(int i=0; i<curr.children.length; i++){
                if(curr.children[i] != null && match(chars, k+1, curr.children[i]))
                    return true;
            }
        }
        else
            return curr.children[chars[k] - 'a'] != null && match(chars, k+1, curr.children[chars[k] - 'a']);
        
        return false;
    }
}
​
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
