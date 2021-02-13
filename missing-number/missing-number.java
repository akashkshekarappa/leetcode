//Bit Manipulation
//TC: O(n)
//SC: O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for(int i=0; i<nums.length; i++){
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}

/*

Index	0	1	2	3
Value	0	1	3	4

  
=4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
=(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
=0∧0∧0∧0∧2
=2
*/