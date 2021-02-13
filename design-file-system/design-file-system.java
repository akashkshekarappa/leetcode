//HashMap key value pair approach
//TC: O(M) for create and get
//SC: O(K)

// class FileSystem {
//     HashMap<String, Integer> map;
//     public FileSystem() {
//         this.map = new HashMap<>();
//     }
    
//     public boolean createPath(String path, int value) {
//         // Step-1: basic path validations
//         if(path.isEmpty() || (path.length() == 1 && path.equals("/")) || map.containsKey(path))
//             return false;
        
//         int delinIndex = path.lastIndexOf("/");
//         String parent = path.substring(0, delinIndex);
//          // Step-2: if the parent doesn't exist. Note that "/" is a valid parent
//         if(parent.length() > 1 && !map.containsKey(parent))
//             return false;
//          // Step-3: add this new path and return true.
//         map.put(path, value);
//         return true;
//     }
    
//     public int get(String path) {
//         return map.getOrDefault(path, -1);
//     }
// }


//Trie based approach
//TC: O(T) for create and get
//SC: O(T) for create and O(1) for get
class FileSystem {
    class TrieNode{
        String name; int value;
        HashMap<String, TrieNode> children;
        TrieNode(String name, int value){
            this.name = name; this.value = value; this.children = new HashMap<>();
        }
    }
    
    private TrieNode root;
    public FileSystem() {
        this.root = new TrieNode("/", -1);
    }
    
    public boolean createPath(String path, int value) {
        String[] folders = path.split("/");
        TrieNode curr = this.root;
        
        String name = folders[folders.length -1];
        
        for(int i=0; i<folders.length-1; i++){
            if(folders[i].equals(""))
                continue;
            if(curr.children.containsKey(folders[i]))
                curr = curr.children.get(folders[i]);
            else
                return false;
        }
        // check if the path exists
        if(curr.children.containsKey(name))
            return false;
        
        curr.children.put(name, new TrieNode(name, value));
        return true;
        
    }
    
    public int get(String path) {
        String[] folders = path.split("/");
        TrieNode curr = this.root;
        
        for(int i=0; i<folders.length; i++){
            if(folders[i].equals(""))
                continue;
            if(curr.children.containsKey(folders[i]))
                curr = curr.children.get(folders[i]);
            else
                return -1;
        }
        return curr.value;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */