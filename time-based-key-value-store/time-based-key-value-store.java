Now, for each key, we can binary search the sorted list of timestamps to find the relevant value for that key.
*/
​
class TimeMap {
     class Node {
        String value;
        int timestamp;
        Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
​
    Map<String, List<Node>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        
        map.get(key).add(new Node(value, timestamp));
    }
  
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        return binarySearch(map.get(key), timestamp); 
    }
    
    private String binarySearch(List<Node> nodes, int timestamp){
        int low = 0;
        int high = nodes.size() -1;
        while(low+1 < high){
            int mid = low + (high - low)/2;
            Node node = nodes.get(mid);
            
            if (node.timestamp == timestamp)
                 return node.value;
            
            else if (node.timestamp < timestamp)
                low = mid + 1;
            
            else
                high = mid - 1;
        }
        
        if (nodes.get(high).timestamp <= timestamp) 
            return nodes.get(high).value;
        else if (nodes.get(low).timestamp <= timestamp) 
            return nodes.get(low).value;
        return "";
    }
}
​
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
