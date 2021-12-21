// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// traversed through the array and subtrated 1 from each element, took the difference as index and went to that particular index
// made the value negative
// did another pass and if the element is positive, added the index of the element +1 to the result

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null && nums.length == 0)
            return null;
        int n = nums.length;
        List<Integer> result = new ArrayList();
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0)
                nums[index] = -1 * nums[index];
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = -1 * nums[i];

            } else {
                result.add(i + 1);
            }
        }
        return result;
    }
}