//TC: O(n^k-1), for 4sum, O(n^3)
//SC: O(n)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    private List<List<Integer>> kSum(int[] nums, int target, int start, int k){
        List<List<Integer>> result = new ArrayList<>();
        if(start == nums.length || nums[start] * k > target || target > nums[nums.length-1] * k)
            return result;
        
        if(k == 2)
            return twoSum(nums, target, start);
        
        for(int i=start; i<nums.length; i++){
            if(i == start || nums[i-1] != nums[i]){
                for(List<Integer> list: kSum(nums, target - nums[i], i+1, k-1)){
                    result.add(new ArrayList<>(Arrays.asList(nums[i])));
                    result.get(result.size()-1).addAll(list);
                }
            }
        }
        return result;
    }
    private List<List<Integer>> twoSum(int[] nums, int target, int start){
        List<List<Integer>> result = new ArrayList<>();
        int low = start;
        int high = nums.length -1;
        while(low < high){
            int sum = nums[low] + nums[high];
            if(sum < target || (low > start && nums[low] == nums[low-1]))
                low++;
            else if(sum > target || (high < nums.length-1 && nums[high] == nums[high+1]))
                high--;
            else
                result.add(Arrays.asList(nums[low++], nums[high--]));
        }
        return result;
    }
}