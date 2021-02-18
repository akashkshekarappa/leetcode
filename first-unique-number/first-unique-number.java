class FirstUnique {

    Set<Integer> set = new LinkedHashSet<>();
    Map<Integer, Boolean> map = new HashMap<>();
    public FirstUnique(int[] nums) {    //O(k)
        for(int num: nums){
            add(num);
        }
        
    }
    
    public int showFirstUnique() {//O(1)
         // If the queue contains values, we need to get the first one from it.
    // We can do this by making an iterator, and getting its first item.
        if(!set.isEmpty())
            return set.iterator().next();
        
        return -1;
    }
    
    public void add(int value) {//O(1)
        //case 1: if it doesnt contain add
        if(!map.containsKey(value)){
            map.put(value, true);
            set.add(value);
        }
        //case 2: This value has been seen once, so is now becoming non-unique. It should be REMOVED
        else if(map.get(value)){
            map.put(value,false);
            set.remove(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */