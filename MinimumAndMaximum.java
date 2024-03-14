// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Use min max for number in pairs, it is 3 * n\2 comparisions

public class MinimumAndMaximum {

/* Pair returns two values */
	static class Pair {

		int min;
		int max;
	}

	static Pair getMinMax(int arr[], int n) {
		Pair minmax = new Pair();
		int i;
		// Even length array: initialize the first two elements as min and max
		if (n % 2 == 0) {
			if (arr[0] > arr[1]) {
				minmax.max = arr[0];
				minmax.min = arr[1];
			} else {
				minmax.min = arr[0];
				minmax.max = arr[1];
			}
			i = 2; //start index
		} // Odd length array: initialize the first element as min and max
        else {
			minmax.min = arr[0];
			minmax.max = arr[0];
			i = 1;//start index
		}

		/* Pick elements in pair and 
	compare the pair with max and min so far */
		while (i < n - 1) {
			if (arr[i] > arr[i + 1]) {
				if (arr[i] > minmax.max) {
					minmax.max = arr[i];
				}
				if (arr[i + 1] < minmax.min) {
					minmax.min = arr[i + 1];
				}
			} else {
				if (arr[i + 1] > minmax.max) {
					minmax.max = arr[i + 1];
				}
				if (arr[i] < minmax.min) {
					minmax.min = arr[i];
				}
			}
			i += 2;
			// Increment the index by 2 as we want pairs
		}

		return minmax;
	}
}
