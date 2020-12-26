//time complexity for adding is O(logN) since lowerKey(), higherKey(), put() and remove() are all O(logN)
class SummaryRanges {
​
    /** Initialize your data structure here. */
    TreeMap<Integer, Integer> treeMap;//[1,3,7,2,0,8]   treeMap.loweKey(2) =>1, treeMap.higherKey(2)=> 3
    public SummaryRanges() {
        treeMap = new TreeMap<>();
    }
    
    public void addNum(int val) {
        //edge case
        if(treeMap.containsKey(val)){
            return;
        }
        Integer lwKey = treeMap.lowerKey(val);
        Integer highKey = treeMap.higherKey(val);
        
        if(lwKey != null && highKey != null && treeMap.get(lwKey)+1 == val && highKey == val + 1){ //4 cases
            treeMap.put(lwKey, treeMap.get(highKey));
            treeMap.remove(highKey);
        }
        else if(highKey != null && highKey == val +1){
            treeMap.put(val, treeMap.get(highKey));
            treeMap.remove(highKey);
        }
        else if(lwKey != null && treeMap.get(lwKey) +1 >= val){
            treeMap.put(lwKey, Math.max(treeMap.get(lwKey), val));
        }
        else{
            treeMap.put(val, val);
        }
    }
    
    public int[][] getIntervals() {
        int size = treeMap.size();
        int[][] result = new int[size][2];
