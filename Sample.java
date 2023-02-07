import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach

/**
 * The main idea is to put each number in its respective index.
 * Iterate the array and for each number check if it is in its
 * correct index, if not swap to that index. After iterate till
 * n and check if that number is that particular index. if not,
 * add it to the answer list and return the list.
 *
 */
class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		int i = 0;
		while (i < nums.length) {
			if (nums[i] != nums[nums[i] - 1]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			} else {
				i++;
			}
		}
		for (int p = 0; p < nums.length; p++)
			if (nums[p] != p + 1)
				ans.add(p + 1);
		return ans;
	}
}