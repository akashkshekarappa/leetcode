//TC: O(numRows^2)
//SC: O(numRows^2)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            List<Integer> rows = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j == 0 || j == i)
                    rows.add(1);
                else
                    rows.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            result.add(rows);
        }
        return result;
    }
}
