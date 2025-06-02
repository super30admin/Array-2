// Approach:
// Use pairwise comparison to reduce total number of comparisons.
// Compare elements in pairs. In each pair, compare the two elements with each other,
// then compare the larger with current max and the smaller with current min.
// This reduces the total comparisons to roughly 1.5n.
//
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] findMinAndMax(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};

        int min, max;
        int i;

        int n = nums.length;

        // Initialize min and max
        if (n % 2 == 0) {
            // If even, compare first two elements
            if (nums[0] < nums[1]) {
                min = nums[0];
                max = nums[1];
            } else {
                min = nums[1];
                max = nums[0];
            }
            i = 2;
        } else {
            // If odd, start with first element as both min and max
            min = max = nums[0];
            i = 1;
        }

        // Compare elements in pairs
        while (i < n - 1) {
            int a = nums[i];
            int b = nums[i + 1];

            if (a < b) {
                min = Math.min(min, a);
                max = Math.max(max, b);
            } else {
                min = Math.min(min, b);
                max = Math.max(max, a);
            }

            i += 2;
        }

        return new int[]{min, max};
    }
}
