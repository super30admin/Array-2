// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

import java.util.ArrayList;
import java.util.List;

public class DisappearedArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Mark the index corresponding to the value as visited (negate the value)
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Convert to 0-based index
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // Mark as visited
            }
        }

        // Collect indices that remain positive (unvisited), which are the missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // Convert back to 1-based index
            }
        }

        return result;
    }
}
    

