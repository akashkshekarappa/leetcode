class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        if(paths == null || paths.length == 0)
            return result;
         //HashMap, key =contents, value = list_of_file_paths_with_this_content
        HashMap<String, List<String>> map = new HashMap<>();
        for(String path: paths){
            String[] values = path.split(" ");
            for(int i=1; i<values.length; i++){
                String[] name_content = values[i].split("\\(");
                name_content[1] = name_content[1].replace(")", "");
                
                List<String> list = map.getOrDefault(name_content[1], new ArrayList<>());
                list.add(values[0] + "/" + name_content[0]);
                
                map.put(name_content[1], list);
            }
        }
        
        for(String key: map.keySet()){
            if(map.get(key).size() > 1)
                result.add(map.get(key));
        }
        return result;
    }
}
