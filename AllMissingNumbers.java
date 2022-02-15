// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: create a boolean array and mark the indexes for
// which we found the numbers.

// LC- 448. Find All Numbers Disappeared in an Array

import java.util.*;

class AllMissingNumbers {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> result = new ArrayList<>();

    if (nums == null || nums.length == 0) {
      return result;
    }

    boolean[] array = new boolean[nums.length + 1];
    array[0] = true;

    for (int i = 0; i < nums.length; i++) {
      array[nums[i]] = true;
    }

    for (int i = 1; i < nums.length + 1; i++) {
      if (!array[i]) {
        result.add(i);
      }
    }

    return result;
  }
}