//TC: O(n)
//SC: O(n)
class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1)
            return 1;
        int[] arr = new int[n];
        arr[0] = 1;  //1st ugly number is 1
        int pt2 = 0; int pt3 = 0; int pt5 = 0;
        int n2  = 0; int n3  = 0; int n5  = 0;
        for(int i=1; i<n; i++){
            //for each index from 1 to n
            //find n2 = 2 * arr[pt2], n3 = 3 * arr[pt3], n5 = 5 * arr[pt5]
            //arr[i] = min(n2,n3,n5)
            //if arr[i] = n2 increase pt2 by 1, if arr[i] = n3 increase pt3 by 1 and if arr[i]              = n5 increase pt5 by 1
            n2 = arr[pt2] * 2;
            n3 = arr[pt3] * 3;
            n5 = arr[pt5] * 5;
            arr[i] = Math.min(n2, Math.min(n3, n5));
            if(n2 == arr[i]){
                pt2++;
            }
            if(n3 == arr[i]){
                pt3++;
            }
            if(n5 == arr[i]){
                pt5++;
            }
        }
        return arr[n-1];       //return last value
    }
}