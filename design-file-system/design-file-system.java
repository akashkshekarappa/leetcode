//HashMap key value pair approach
//TC:
//SC:

class FileSystem {
    HashMap<String, Integer> map;
    public FileSystem() {
        this.map = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        // Step-1: basic path validations
        if(path.isEmpty() || (path.length() == 1 && path.equals("/")) || map.containsKey(path))
            return false;
        
        int delinIndex = path.lastIndexOf("/");
        String parent = path.substring(0, delinIndex);
         // Step-2: if the parent doesn't exist. Note that "/" is a valid parent
        if(parent.length() > 1 && !map.containsKey(parent))
            return false;
         // Step-3: add this new path and return true.
        map.put(path, value);
        return true;
    }
    
    public int get(String path) {
        return map.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */