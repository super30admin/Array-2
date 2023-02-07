// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/**
 * Take two variables for max and min. Iterate
 * the array and update max and min every index.
 * Finally add max and min and return the sum.
 *
 */
class Solution {
	public static int findSum(int A[], int N) {
		// code here
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int num : A) {
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		return max + min;
	}
}
