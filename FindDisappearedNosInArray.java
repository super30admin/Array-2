import java.util.ArrayList;
import java.util.List;

// Time Complexity :O(2n) => O(n)
// Space Complexity : O(1) , since the ArrayList result is expected by the program itself, so no extra space is used.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1; // absolute value to calculate the index properly.
            if (nums[index] > 0) {
                nums[index] = nums[index] * (-1); // making the value negative to understand index+1 number is there in
                                                  // the array
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // if any index holds a positive value, it means index+1 values is not present
                                   // in the array.
            }
        }

        return result;
    }
}