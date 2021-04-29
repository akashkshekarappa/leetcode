//Time Complexity :O(log n), number of elements in the array
//Space Complexity : O(1)

class Solution {
    public int hIndex(int[] citations) {
       int low =0;
		int high = citations.length -1;
		while(low <= high){
			int mid = low + (high - low)/2;
			int diff = citations.length - mid;	// finding h index
			if(citations[mid] == diff)	// if the citations become equal to h index
				return citations[mid];
			else if (citations[mid] < diff)	// if citation is less than diff we have to move right
				low = mid + 1;
			else
				high = mid - 1;
		}
		return citations.length - low;	// if they don't become equal and citations crosses it, the h index is found at low index

    }
}