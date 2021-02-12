class FreqStack {

    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> group;
    int maxFreq;
    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int x) {
        int fq = freq.getOrDefault(x, 0) +1;
        freq.put(x, fq);
        
        maxFreq = Math.max(maxFreq, fq);
        
        if(!group.containsKey(fq))
            group.put(fq, new Stack<>());
    
        group.get(fq).add(x);
    }
    
    public int pop() {
        int x = group.get(maxFreq).pop();
        freq.put(x, maxFreq-1);
        if(group.get(maxFreq).size() == 0)
            maxFreq--;
        
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */