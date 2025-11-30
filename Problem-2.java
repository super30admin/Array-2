// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :no
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// Initialize the global min and max by comparing the first one or two elements.
// Scan the array in pairs, comparing each pair to find a local min and max.
// Update the global min and max using each pair’s local results to reduce total comparisons.
class Problem2 {

    public int[] findMinAndMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int min, max;
        int start;

        // Initialize min and max
        if (nums.length % 2 == 0) {
            // Even length → compare first pair
            if (nums[0] < nums[1]) {
                min = nums[0];
                max = nums[1];
            } else {
                min = nums[1];
                max = nums[0];
            }
            start = 2;
        } else {
            // Odd length → start with first element
            min = nums[0];
            max = nums[0];
            start = 1;
        }

        // Process remaining elements in pairs
        for (int i = start; i < nums.length; i += 2) {
            int localMin, localMax;

            if (nums[i] < nums[i + 1]) {
                localMin = nums[i];
                localMax = nums[i + 1];
            } else {
                localMin = nums[i + 1];
                localMax = nums[i];
            }

            // Update global min and max
            if (localMin < min) min = localMin;
            if (localMax > max) max = localMax;
        }

        return new int[]{min, max};
    }
}
