// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// Use the input array itself to track which numbers have been seen by marking their corresponding indices as negative.
// After marking, any index that remains positive indicates that its number was never visited.
// Collect all such indices + 1 to get the list of missing numbers.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Mark each number's corresponding index as negative
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        // Collect all indices that are still positive → missing numbers
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                output.add(i + 1);
            }
        }

        return output;
    }
}