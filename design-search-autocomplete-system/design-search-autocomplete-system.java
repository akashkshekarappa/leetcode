class AutocompleteSystem {

    HashMap<String, Integer> map;//map of sentence to its freq
    String inputTracker;//current i/p query string - maintained till # is pressed
    int MAX_RESULT_SIZE; //number of sugesstions in result
    public AutocompleteSystem(String[] sentences, int[] times) {
        map = new HashMap<>();
        inputTracker = "";
        MAX_RESULT_SIZE = 3;
        for(int i=0; i<sentences.length; i++){
            //no duplicates in sentences[] - else handlle duplicates
            map.put(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        //if c = '#' - handle enter
        if(c == '#'){
            if(inputTracker.length() != 0){//if there are chars in input tracker, add he input tracker string to map
                if(map.containsKey(inputTracker)){
                    map.put(inputTracker, map.get(inputTracker) +1);
                }
                else{
                    map.put(inputTracker, 1);
                } 
            }
            inputTracker = "";//reset input tracker to empty
            return new ArrayList<>();
        }
        //esle append c to input
        inputTracker += c;
        //build pq, pq is max heap with sentence frequence (lexicographic order in case of same frequency)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> (a.count == b.count? a.sentence.compareTo(b.sentence) : b.count - a.count));
        //add all sentences that starts with input tracker into pq
        for(String sentence: map.keySet()){
            if(sentence.startsWith(inputTracker)){
                pq.add(new Pair(sentence, map.get(sentence)));
            }
        }
        
        //Populate result and output
        List<String> result = new ArrayList<>();
        while(!pq.isEmpty() && result.size() < MAX_RESULT_SIZE){
            result.add(pq.poll().sentence);
        }
        return result;
    }
}
public class Pair {
    String sentence;
    int count;

    public Pair(String sentence, int count) {
        this.sentence = sentence;
        this.count = count;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */