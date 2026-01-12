// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Only thing is handling odd length array properly.


// Your code here along with comments explaining your approach in three sentences only
// Instead of comparing every element with both min and max, we compare elements in pairs.
// For each pair, we first decide which one is smaller and which one is bigger, then update min and max accordingly.
// This reduces comparisons and gives better than 2*(n-2) comparisons.

class Solution {
    public int[] findMinMax(int[] nums) {

        int n = nums.length;
        int min, max;
        int i = 0;

        // init min and max based on first one or first two
        if (n % 2 == 0) {
            if (nums[0] < nums[1]) {
                min = nums[0];
                max = nums[1];
            } else {
                min = nums[1];
                max = nums[0];
            }
            i = 2;
        } else {
            min = nums[0];
            max = nums[0];
            i = 1;
        }

        // compare in pairs
        while (i < n - 1) {

            int a = nums[i];
            int b = nums[i + 1];

            if (a < b) {
                if (a < min) min = a;
                if (b > max) max = b;
            } else {
                if (b < min) min = b;
                if (a > max) max = a;
            }

            i += 2;
        }

        return new int[]{min, max};
    }
}
