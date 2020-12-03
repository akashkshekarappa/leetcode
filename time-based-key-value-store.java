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
            
             if (node.timestamp == timestamp) {
                return node.value;
            } else if (node.timestamp < timestamp) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
if (nodes.get(high).timestamp <= timestamp) return nodes.get(high).value;
        else if (nodes.get(low).timestamp <= timestamp) return nodes.get(low).value;
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
