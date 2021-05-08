//Top Down Dynamic Programming - Memoization
//TC: O(m . n)
//SC: O(m . n)

class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i=0; i<nums.length; i++)
            totalSum+= nums[i];
        
        // if totalSum is odd,it cannot be partitioned into equal sum subset
        if(totalSum % 2 != 0) return false;
        
        int subset = totalSum / 2;
        Boolean[][] memo = new Boolean[nums.length+1][subset + 1];
        return dfs(nums, nums.length-1, subset, memo);
    }
    private boolean dfs(int[] nums, int n, int subsetSum, Boolean[][] memo){
        //base case;
        if(subsetSum == 0) return true;
        if(n == 0 || subsetSum < 0) return false;
        
        // check if subSetSum for given n is already computed and stored in memo
        if(memo[n][subsetSum] != null)
            return memo[n][subsetSum];
        
        boolean result = dfs(nums, n-1, subsetSum - nums[n-1],memo) || dfs(nums, n-1, subsetSum, memo);
        
        //store the result in memo
        memo[n][subsetSum] = result;
        
        return result;
    }
}










//Brute force, Recursion
//TC: O(2 ^n)
//SC: O(n)
/*class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i=0; i<nums.length; i++)
            totalSum+= nums[i];
        
        // if totalSum is odd,it cannot be partitioned into equal sum subset
        if(totalSum % 2 != 0) return false;
        
        int subset = totalSum / 2;
        return dfs(nums, nums.length-1, subset);
    }
    private boolean dfs(int[] nums, int n, int subsetSum){
        //base case;
        if(subsetSum == 0) return true;
        if(n == 0 || subsetSum < 0) return false;
        
        //logic, choose and not choose
        return dfs(nums, n-1, subsetSum - nums[n-1]) || dfs(nums, n-1, subsetSum);
    }
}*/