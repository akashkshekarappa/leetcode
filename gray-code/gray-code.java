class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        
        for(int i=0; i<n; i++){
            int inc = 1<<i;
            
            for(int k=list.size()-1; k>=0; k--){
                list.add(list.get(k) + inc);
            }
        }
        return list;
    }
}