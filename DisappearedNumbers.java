/*448. Find All Numbers Disappeared in an Array 
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:
Input: nums = [1,1]
Output: [2]
 
Constraints:
n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
*/

/*
Time Complexity:-O(n)
Space Complexity:-O(1)
Approach:-We're given an array of size n with numbers from 1 to n. Some numbers are missing and some may be duplicates. To find missing numbers without extra space, we mark visited indices(diff = Math.abs(nums[i]) - 1) as negative.
Second pass: Any index with a positive number indicates the number (index + 1) was never seen.
 */
class DissapearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Edge case: empty array
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int n = nums.length;
        int diff = 0;// used to compute target index
        List<Integer> result = new ArrayList<>();
        // First pass: mark visited indices as negative
        for (int i = 0; i < n; i++) {
            diff = Math.abs(nums[i]) - 1;// convert value to index (1-based to 0-based)
            if (nums[diff] > 0) { // only mark once
                nums[diff] = nums[diff] * -1; // mark as visited by making it negative
            }
        }
        // Second pass: collect indices that are still positive
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) { // if still positive, number (i+1) was not visited
                result.add(i + 1);
            }
        }
        return result;// return all missing numbers
    }
}