            }
        }
        return root;
    }
    private List<String> allStartsWith(TrieNode root, String prefix){
        TrieNode curr = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null){
                return new ArrayList<>();
            }
            curr = curr.children[c-'a'];
        }
        return curr.startsWith;
    }
    
    List<List<String>> result;
    public List<List<String>> wordSquares(String[] words) {
        result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        List<String> list = new ArrayList<>();
        for(String word: words){
            //action
            list.add(word);
            //recurse
            backtrack(root, list, word.length());
            //backtrack
            list.remove(list.size() -1);
        }
        return result;
    }
    
    private void backtrack(TrieNode root,List<String> list, int length){
        //base case
        if(list.size() == length){
            result.add(new ArrayList<>(list));
            return;
        }
        
        //logic
        int i = list.size();
        StringBuilder prefix = new StringBuilder();
        for(String listWords: list){
            prefix.append(listWords.charAt(i));
        }
        List<String> allStartsWith = allStartsWith(root, prefix.toString());
        for(String word: allStartsWith){
            //action
            list.add(word);
            //recurse
            backtrack(root, list, length);
            //backtrack
            list.remove(list.size() -1);
        }
    }
}
