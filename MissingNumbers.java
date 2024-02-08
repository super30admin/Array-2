// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Marking indexes for elements that exist with negative number
// eg: If 4 exists in the array; mark element at index 3 as negative
// at the end; filter out the positive numbers as they are the res 

import java.util.ArrayList;
import java.util.List;

class MissingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        // iterating over the numbers and mark existing indexes as negative
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            } else {
                // reverting back to the original array
                nums[i] *= -1;
            }
        }

        return res;
    }
}