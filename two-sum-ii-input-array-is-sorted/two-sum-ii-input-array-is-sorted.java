//Two Pointers
//TC: O(n),Each of the n elements is visited at most once
//SC: O(1), We only use two indexes
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0)
            return new int[] {-1, -1};
        int low = 0;
        int high = numbers.length -1;
        while(low < high){
            int sum = numbers[low] + numbers[high];
            if(sum == target)
                return new int[] {low +1, high +1};
            else if(sum < target)
                low++;
            else
                high--;
        }
        return new int[] {-1, -1};
    }
}
