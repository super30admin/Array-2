// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0)
                nums[index] *= -1;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0)
                result.add(i + 1);
        }

        return result;
    }
}
