package Oct27;

public class MinMaxInArray {

	/* 
	Time Complexity: O(n) where n is no.of elements in nums array.
	Because we need to iterate through all elements of nums array.

	Space Complexity: O(1)
	No extra space used, so O(1).
	      
	Did this code successfully run on Eclipse : Yes

	Any problem you faced while coding this : No

	Approach:
	Array elements compared in pairs to each other to find local min and max.
	This local min is then compared with global min and max.
	In case array has odd no.of elements, last elem compared to global min and max to determine final values of global min and max.
	  
	*/
	
	public static void main(String[] args) {
		int[] arr = {1,4,7,-90,100,140};
		findMinMax(arr);
	}

	private static void findMinMax(int[] arr) {
		
		// edge cases
		if (arr == null || arr.length == 0) {
			return;
		}
		
		int globalMin = Integer.MAX_VALUE;
		int globalMax = Integer.MIN_VALUE;
		int localMin = 0;
		int localMax = 0;
		
		// used to track last array element when odd no.of elements in the given array
		int lastElem = 0;
		boolean isLast = false;
		
		// finding out if array has odd no.of elements
		int len = arr.length;
		if (len%2 != 0 ) {
			isLast = true;
			lastElem = arr[len-1];
		} 
		
		// traversing the array in hops of 2 such that a pair of adjacent elem are compared to each other first and then to global min and max
		for (int i = 0; i < len-1; i = i+2) {
			if (arr[i] < arr[i+1]) {
				localMin = arr[i];
				localMax = arr[i+1];
			} else {
				localMin = arr[i+1];
				localMax = arr[i];
			}
			globalMin = Math.min(globalMin, localMin);
			globalMax = Math.max(globalMax, localMax);
		}
		
		// for odd no.of elements in array, last element has yet not been included in comparisons in the FOR loop
		// hence comparing global min and max with last element
		if (isLast) {
			globalMin = Math.min(globalMin, lastElem);
			globalMax = Math.max(globalMax, lastElem);
		}
		
		System.out.println(globalMin + "  " + globalMax);
		
	}

}
