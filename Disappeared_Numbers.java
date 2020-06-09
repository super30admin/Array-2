// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.List;
import java.util.ArrayList;

public class Disappeared_Numbers {
	/*
	 * In this function we iterate through the array and at each index we go to the
	 * index - 1 of the value of the current index and multiply it by -1. After
	 * doing this we iterate through the array again and see if any of the value is
	 * positive, if it is then we add 1 to that particular index and add it into our
	 * list
	 */
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0) {
				nums[index] = nums[index] * -1;
			}
		}
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] > 0) {
				list.add(j + 1);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int nums[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> result = new ArrayList<Integer>();
		result = findDisappearedNumbers(nums);
		System.out.println(result);
	}
}