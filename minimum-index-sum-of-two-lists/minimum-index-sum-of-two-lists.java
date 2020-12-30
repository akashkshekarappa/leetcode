//TC: O(n + m)
///SC: O(n)
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<list1.length; i++){
            map.put(list1[i], i);
        }
        
        HashMap<Integer, List<String>> result = new HashMap<>();
        for(int i=0; i<list2.length; i++){
            String str = list2[i];
            if(map.containsKey(str)){
                int sum = i + map.get(str);
                List<String> list = result.getOrDefault(sum, new ArrayList());
                list.add(str);
                result.put(sum, list);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int sum: result.keySet())
            min = Math.min(min, sum);
        
        return result.get(min).toArray(new String[0]);
    }
}
