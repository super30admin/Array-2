// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Could not find
// Any problem you faced while coding this : No

import java.util.Arrays;

public class Max_Min {
	/*
	 * This function calculates the max and min value of our given array. We do this
	 * by comparing the values in each pair with each other, and then comparing them
	 * with both the max and min values
	 */
	public static int[] max_min(int nums[]) {
		int result[] = new int[2];
		int max = nums[0];
		int min = nums[0];
		for (int i = 0; i < nums.length; i = i + 2) {
			if (i == nums.length - 1) {
				if (nums[i] > max) {
					max = nums[i];
					result[0] = max;
				}
				if (nums[i] < min) {
					min = nums[i];
					result[1] = min;
				}
			} else if (nums[i] > nums[i + 1]) {
				if (nums[i] > max)
					max = nums[i];
				if (nums[i + 1] < min) {
					min = nums[i + 1];
				}
			} else {
				if (nums[i + 1] > max)
					max = nums[i + 1];
				if (nums[i] < min) {
					min = nums[i];
				}
			}
			result[0] = max;
			result[1] = min;
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 8, 6, 2, 1, 5, 70 };
		int result[] = max_min(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("Maximum: " + result[0]);
		System.out.println("Minimum: " + result[1]);
	}
}