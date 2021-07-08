// Time Complexity : O(n), n -> Number of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class MaxAndMin {
	public int[] getMinAndMax(int[] nums) {
		int[] ans = new int[] { -1, -1 };
		if (nums == null || nums.length == 0) {
			return ans;
		}

		int n = nums.length;
		int i = 0;
		if (n % 2 == 0) {
			if (nums[0] > nums[1]) {
				ans[0] = nums[1];
				ans[1] = nums[0];
			} else {
				ans[0] = nums[0];
				ans[1] = nums[1];
			}
			i = 2;
		} else {
			ans[0] = nums[0];
			ans[1] = nums[0];
			i = 1;
		}

		while (i < n - 1) {
			if (nums[i] > nums[i + 1]) {
				if (nums[i] > ans[1]) {
					ans[1] = nums[i];
				}
				if (nums[i + 1] < ans[0]) {
					ans[0] = nums[i + 1];
				}
			} else {
				if (nums[i + 1] > ans[1]) {
					ans[1] = nums[i + 1];
				}
				if (nums[i] < ans[0]) {
					ans[0] = nums[i];
				}
			}
			i += 2;
		}

		return ans;
	}

	public static void main(String[] args) {
		MaxAndMin obj = new MaxAndMin();
		int[] nums = { 1000, 11, 445, 1, 330, 3000 };
		int[] ans = obj.getMinAndMax(nums);
		System.out.println("Minimum and maximum in the array: " + ans[0] + ", " + ans[1]);
	}

}
