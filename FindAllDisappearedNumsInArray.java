// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: First we iterate through the array and for each number num, make the corresponding number at index [num-1] negative
// 2: Then the next iteration is to determine which remaining elements are positive
// 3: If we find a positive element, we return the index + 1. At the end, we revert the input array to its original elements
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = nums[idx] * -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            } else {
                nums[i] *= -1;
            }
        }
        return result;

    }
}