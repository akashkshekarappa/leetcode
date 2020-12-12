class RandomizedCollection {
​
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    java.util.Random random = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val))   //if value is not present in map, then insert in to map
            map.put(val, new LinkedHashSet<>());
        
        
        map.get(val).add(list.size());
        list.add(val);
​
        return map.get(val).size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size()== 0)
            return false;
        
        int removeIndex = map.get(val).iterator().next();
        map.get(val).remove(removeIndex);
        
        int last = list.get(list.size()-1);
        list.set(removeIndex, last);
        
        map.get(last).add(removeIndex);
        map.get(last).remove(list.size()-1);
        list.remove(list.size()-1);
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
​
/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
