import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * To optimize on space, we are doing in-place state changes
 * where negative elements represent that the number that should be
 * on that index is present in the array. At last all the indices where numbers
 * are positive are the missing number. i.e (index + 1)
 */

public class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index;
            if (nums[i] > 0) {
                index = nums[i] - 1;
            } else {
                index = Math.abs(nums[i]) - 1;
            }

            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
