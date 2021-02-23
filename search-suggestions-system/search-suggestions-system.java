//Priority Queue
//TC: O(n log k)
//SC: O(k)
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i <= searchWord.length(); i++) {
            String t = searchWord.substring(0, i);
            for (String product: products) {
                if (product.startsWith(t)) {
                    pq.add(product);
                }
                if (pq.size() > 3) {
                    pq.poll();
                }
            }
            
            LinkedList<String> temp = new LinkedList<>();
            while (!pq.isEmpty()) {
                temp.addFirst(pq.poll());
            }
            result.add(temp);
        }
        return result;
    }
}