// Time Complexity : O(n) — two passes through the array of size n
// Space Complexity : O(1) — excluding the result list; in-place marking is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// The idea is to use the input array itself to record which numbers were seen.
// For every number `x`, mark index `x - 1` as visited by negating the value at that index.
// In the second pass, the indices with positive values correspond to missing numbers.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // First pass: mark visited indices as negative
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;  // Convert value to index (1-based to 0-based)
            if (nums[idx] > 0) {
                nums[idx] = Math.negateExact(nums[idx]);  // Mark as visited
            }
        }

        // Second pass: collect indices where value is still positive (i.e., number not seen)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);  // Add missing number (convert index back to 1-based)
            } else {
                // Optional: restore array to original state by un-negating values
                nums[i] = Math.negateExact(nums[i]);
            }
        }

        return result;
    }
}