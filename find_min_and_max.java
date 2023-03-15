import java.util.List;
import java.util.Arrays;

// Time Complexity : O(n); n = nums.length
// Space Complexity : O(1)
// Total comparisons: 3n/2 = 1.5n instead of 2n comparisons.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        if(nums.length == 1) {
            return Arrays.asList(nums[0], nums[0]);
        }

        int min = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length - 1; i++) {
            if(nums[i] < nums[i+1]) {
                max = Math.max(max, nums[i+1]);
                min = Math.min(min, nums[i]);
            } else {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i+1]);
            }
        }

        return Arrays.asList(min, max);
    }
}