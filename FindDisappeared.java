/*We use the in-place negative marking approach:
1. Iterate over nums:
    Take the absolute value of the current number.
    Compute index = num - 1.
    If nums[index] > 0, multiply by -1 to mark as visited.
2. Iterate over nums again:
    If nums[i] is positive, then i+1 was never visited → add to result.
    Else, restore nums[i] to positive to retain original array.

Time Complexity: O(n) → One pass to mark visited and one pass to collect results.
Space Complexity: O(1) → No extra space except the output list.
*/

import java.util.ArrayList;
import java.util.List;

public class FindDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        // Step 1: Mark visited numbers
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            int index = num - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        // Step 2: Collect missing numbers & restore array
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            } else {
                nums[i] *= -1; // Restore original value
            }
        }

        return result;
    }
}