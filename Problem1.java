// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NONE


import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {  // If the element is +ve, it means we haven't seen it yet
                nums[index] = -nums[index]; // Flip the sign to indicate presence
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) result.add(j + 1);
        }

        return result;
    }
}