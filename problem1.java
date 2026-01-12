// Time Complexity : O(n)
// Space Complexity : O(1)  (output list not counted)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, just need to use abs() while marking.


// Your code here along with comments explaining your approach in three sentences only
// Since values are from 1 to n, we use each value as an index and mark that index as visited by making it negative.
// After marking, any position that still has a positive number means that (index+1) never appeared in the array.
// Finally, we collect all such missing numbers into the answer list.

import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) nums[idx] = -nums[idx];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res.add(i + 1);
        }

        return res;
    }
}
