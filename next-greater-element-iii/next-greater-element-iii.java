//Same as next permutation
//Time Complexity :O(n), size of array
//Space Complexity :O(1)
class Solution {
    public int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();
		int i = a.length-2;    //will start checking at second last value;
		//Step1: find breach
		while(i>=0 && a[i] >= a[i+1]){     // if value is greater than next...keep moving
			i--;    // we stop when we find a breach i.e  value at i is less than next value
		}
        
          if (i < 0)
            return -1;
        
		//Step2: Find element to be swapped
		int j = a.length-1;
		if(i >=0){  // till i is present i.e there is a breach
			while(a[i] >= a[j]){  // reach the point where the value is just greater than value at i
				j--;
			}
			swap(a, i, j);
		}
		//Step3: Reverse the numbers
		reverse(a, i+1, a.length-1);
        
        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
	}
	private void swap(char[] nums, int i, int j){
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	private void reverse(char[] nums, int i, int j){
		while(i < j){
			swap(nums, i, j);
			i++;
			j--;
		}
	} 
}