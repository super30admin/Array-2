// Time Complexity : O(1.5n)  n=number of elements in array.
// Space Complexity :O(1)   
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No



public class MinMax {
	public static int[] findMinMax(int[] arr) {
		int length = arr.length;
		int[] result = new int[2];
		int min = arr[0], max = arr[1];
		int cond;
		if (length % 2 == 0) {
			cond = length;
		} else {
			cond = length - 1;
		}
		for (int i = 0; i < length - 1; i = i + 2) {
			if (arr[i] > arr[i + 1]) {
				if (min > arr[i + 1]) {
					min = arr[i + 1];
				}
				if (max < arr[i]) {
					max = arr[i];
				}
			} else {
				if (min > arr[i]) {
					min = arr[i];
				}
				if (max < arr[i + 1]) {
					max = arr[i + 1];
				}
			}
		}
		if (length % 2 != 0) {
			min = Math.min(min, arr[length - 1]);
			max = Math.max(max, arr[length - 1]);

		}
		result[0] = min;
		result[1] = max;
		return result;
	}

	public static void main(String args[]) {
		int[] res = findMinMax(new int[] { 1, 2, 3, 4, 5, 6, 0 });
		System.out.print("min:" + res[0] + " max:" + res[1]);
	}

}

