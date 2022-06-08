/* Time Complexity: O(n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

class Solution {

    public static int[] minMax1(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] > nums[i + 1]) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i + 1]);
            } else {
                max = Math.max(max, nums[i + 1]);
                min = Math.min(min, nums[i]);
            }
        }
        return new int[] { min, max };
    }
}
