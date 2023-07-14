// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int n = nums.length;

        // Iterate over the array and mark the corresponding index as negative
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1; // Get the index by taking the absolute value of the number minus 1

            if (nums[index] > 0) {
                nums[index] *= -1; // Mark the number at index as negative to indicate its presence
            }
        }

        // Iterate over the array and add the positive numbers to the result list
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // Add the missing number to the result list
            }
        }

        return result;
    }
}
