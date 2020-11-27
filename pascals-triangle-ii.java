//TC: O(n^2)
//SC: O(k)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rows = new ArrayList<>();
        for(int i=0; i<rowIndex+1; i++){
            rows.add(1);
            for(int j=i-1; j>0; j--){
                rows.set(j, rows.get(j-1) + rows.get(j));
            }
        }
        return rows;
    }
}
