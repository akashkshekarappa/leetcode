//Two pointer
//TC: O(n)
//SC: O(1)
class Solution {
    public int minCost(String s, int[] cost) {
        int result = 0;
        if(s.length() == 0 || s.length() == 1)
            return 0;
        int pt1 = 0;
        int pt2 = 1;
        
        while(pt2 < s.length()){
            if(s.charAt(pt1) == s.charAt(pt2)){
                if(cost[pt1] < cost[pt2]){
                    result += cost[pt1];
                    pt1 = pt2;
                    pt2++;
                }
                else{
                    result += cost[pt2];
                    pt2++;
                }
            }
            else{
                pt1 = pt2;
                pt2++;
            }
        }
        return result;
    }
}
