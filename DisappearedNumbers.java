import java.util.ArrayList;
import java.util.List;

// Approach: Temporary state change pattern with two pass solution
// Time complexity: N + N ~= O(N)
// Space complexity: O(1) no extra space except for output.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i ++) {
            int index = Math.abs(nums[i]) - 1; // Take absolute value to avoid double marking of the index
            if (nums[index] > 0) {
                nums[index] *= -1; // Mark the value at the index as negative
            }
        }
        for (int i = 0; i < length; i ++) {
            if (nums[i] > 0) {
                // if the number is positive then i + 1 is missed/disappeared
                result.add(i + 1);
            } else {
                nums[i] *= -1; // Changing the number to its original value
            }
        }
        return result;
    }
}