// Time Complexity : O(N) //N is the length of array.
// Space Complexity : O(1) //result array of fixed length 2
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : no


/**
 * 1. if array length is even take first two element other wise first element and set index as well.
 * 2. loop through array and compare element as pairs.
 * 3. for a pair it makes 3 comparisons. 1.5 comparisons per pair compared to 2 comparisons in brute force. 
 */
public class FindMinMaxInArray {

	public int[] getMinMax(int arr[]) {
		int n = arr.length;
		int[] result = new int[2];

		int i = 0;

		// if array length is even take first two element other wise first element and
		// set index
		if (n % 2 == 0) {
			if (arr[0] > arr[1]) {
				result[1] = arr[0];
				result[0] = arr[1];
			} else {
				result[0] = arr[0];
				result[1] = arr[1];
			}
			i = 2;
		} else {
			result[0] = arr[0];
			result[1] = arr[0];
			i = 1;
		}

		for (; i < n - 1; i += 2) {
			if (arr[i] > arr[i + 1]) {
				if (arr[i] > result[1]) {
					result[1] = arr[i];
				}
				if (arr[i + 1] < result[0]) {
					result[0] = arr[i + 1];
				}
			} else {
				if (arr[i + 1] > result[1]) {
					result[1] = arr[i + 1];
				}
				if (arr[i] < result[0]) {
					result[0] = arr[i];
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {
		int arr[] = { 1000, 11, 445, 1, 330, 3000 };
		int[] result = new FindMinMaxInArray().getMinMax(arr);
		System.out.printf(result[0] + ".." + result[1]);

	}
}