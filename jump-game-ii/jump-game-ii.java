class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;
        
        /***[2,3,1,1,4]
        Jumps       currInt         nextInt
            1       2               2
            1       2               Math.max(nextInt, nums[i] + i) => max(2, 3+1) =>4
            2       4               max(4, 1+2) = >4
            2       4               max(4, 1+3) => 4
            2       4               max(4, 4+4) => 8
        
        ***/
        int jumps = 1;
        int currInt = nums[0];
        int nextInt = nums[0];
        for(int i=1; i<nums.length; i++){
            nextInt = Math.max(nextInt, nums[i] + i);
            if(currInt != nums.length-1 && currInt == i){
                currInt = nextInt;
                jumps++;
            }
        }
        return jumps;
    }
}
