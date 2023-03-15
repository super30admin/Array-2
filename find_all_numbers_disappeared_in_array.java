import java.util.List;
import java.util.ArrayList;

// Time Complexity : O(n); n = nums.length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null) {
            return null;
        }

        for(int i = 0; i < nums.length; i++) {
            // If already marked visited, skip
            if(nums[Math.abs(nums[i]) - 1] < 0) {
                continue;
            }

            // Mark visited by negating
            nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            // Unseen numbers will not be negative
            if(nums[i] > 0) {
                result.add(i+1);
            }
        }

        return result;
    }
}