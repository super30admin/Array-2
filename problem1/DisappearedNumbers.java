// Time Complexity : O(n), n -> Number of elements
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisappearedNumbers {
	/* ------------------------- InPlace ------------------------- */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ans = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return ans;
		}

		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int idx = Math.abs(nums[i]) - 1;
			if (nums[idx] > 0) {
				nums[idx] *= -1;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (nums[i - 1] > 0) {
				ans.add(i);
			}
		}

		for (int i = 0; i < n; i++) {
			if (nums[i] < 0) {
				nums[i] *= -1;
			}
		}

		return ans;
	}

	/* ------------------------- HashMap ------------------------- */
	public List<Integer> findDisappearedNumbersHashMap(int[] nums) {
		List<Integer> ans = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return ans;
		}

		int n = nums.length;
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

		for (int i = 0; i < n; i++) {
			map.put(nums[i], true);
		}

		for (int i = 1; i <= n; i++) {
			if (!map.containsKey(i)) {
				ans.add(i);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		DisappearedNumbers obj = new DisappearedNumbers();
		int[] nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> ans = obj.findDisappearedNumbers(nums);
		System.out.print("Disappeared Numbers: ");
		for (Integer num : ans) {
			System.out.print(num + " ");
		}
	}

}
