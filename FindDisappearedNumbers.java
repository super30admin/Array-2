
/**
 * Time complexity: O(n)
 * Space complexity: O(1) since list of integers is the return type expected.
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: No
 * Approach: We iterate over the array and we use the value as an index to
 * negate the value present at that index.
 * After one pass, we iterate over the array again and indexes of any positive numbers
 * will be used to return our result.
 */

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] > 0) {
        nums[index] = nums[index] * -1;
      }
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] > 0) {
        result.add(i + 1);
      }
    }
    return result;
  }
}
