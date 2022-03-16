// Time Complexity : O(n) where is the length of the input
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 1) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] > 0) {
                res.add(i + 1);
            } else {
                nums[i] *= -1;
            }
        }

        return res;
    }
}