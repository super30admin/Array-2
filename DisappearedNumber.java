// Time Complexity : O(N) + O(N) => O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

class DisappearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums != null && nums.length != 0) { //edge cases
            for (int i = 0; i < nums.length; i++) { //O(N
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] > 0) nums[index] *= -1; //sentinel value
            }

            for (int i = 0; i < nums.length; i++) { //O(N
                if (nums[i] > 0) result.add(i + 1);
            }
        }

        return result;

    }
}
