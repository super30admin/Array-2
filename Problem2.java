// Time Complexity : O(n). NUmber of comparisons ~3n/2
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : didn't find problem on lc
// Any problem you faced while coding this : n
class Solution {

	class MinMax {
		int min, max;
	}

	public MinMax getMinMax(int arr[]) {
		MinMax minmax = new MinMax();
		int n = arr.length, i = 0;

		if (n % 2 == 0) {
			if (arr[0] > arr[1]) {
				minmax.max = arr[0];
				minmax.min = arr[1];
			} else {
				minmax.min = arr[0];
				minmax.max = arr[1];
			}
			i += 2;
		} else {
			minmax.min = arr[0];
			minmax.max = arr[0];
			i += 1;
		}

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
		}

		return minmax;
	}

}
