class File{
    StringBuilder sb = new StringBuilder();
    String name = "";
    Map<String, File> map = new HashMap<>();
    boolean isFile = false;
    File(){ }
    File(String name){this.name = name;}
}
class FileSystem {

    private File root= null;
    public FileSystem() {
        root = new File();
    }
    
    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        String[] strs = path.split("/");
        File curr = findAndBuild(path);
        if(curr.isFile){
            result.add(curr.name);
            return result;
        }
        result = new ArrayList<>(curr.map.keySet());
        Collections.sort(result);
        return result;
    }
    
    public void mkdir(String path) {
        File f = findAndBuild(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        File f = findAndBuild(filePath);
        f.isFile = true;
        f.sb.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        File f = findAndBuild(filePath);
        if(f.isFile)
            return f.sb.toString();
        return "Not a file";
    }
    
    private File findAndBuild(String path){
        File curr = root;
        String[] strs = path.split("/");
        if(strs.length == 0)
            return root;
        
        for(int i=1; i<strs.length; i++){
            curr.map.putIfAbsent(strs[i], new File(strs[i]));
            curr = curr.map.get(strs[i]);
        }
        return curr;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */