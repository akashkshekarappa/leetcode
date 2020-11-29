//TC: O(n)
//SC: O(1)
class Solution {
    public void sortColors(int[] nums) {
        int i;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for(i=0; i<nums.length; i++){
            if(nums[i] == 0)
                count0++;
            if(nums[i] == 1)
                count1++;
            if(nums[i] == 2)
                count2++;
        }
        i=0;
        
        while(count0 > 0){
            nums[i++] = 0;
            count0--;
        }
        while(count1 > 0){
            nums[i++] = 1;
            count1--;
        }
        while(count2 > 0){
            nums[i++] = 2;
            count2--;
        }
    }
}
