// Approach:
// Use a HashSet to record all numbers present in the array.
// Then iterate from 1 to n and check which numbers are missing.
// Those not in the set are added to the result list.

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();

        // Add all elements to a HashSet
        for (int i = 0; i < nums.length; i++)
            hs.add(nums[i]);

        // Check for numbers from 1 to n not in the set
        for (int i = 1; i <= nums.length; i++) {
            if (!hs.contains(i))
                ls.add(i); // Add missing number to result
        }

        return ls;
    }
}
