// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
public class Problem3 {

    public int[] findMinAndMax(int[] nums) {
        int n = nums.length;
        int min, max;
        int i;

        if (n % 2 == 0) {
            if (nums[0] < nums[1]) {
                min = nums[0];
                max = nums[1];
            } else {
                min = nums[1];
                max = nums[0];
            }
            i = 2;
        } else {
            min = max = nums[0];
            i = 1;
        }

        while (i < n - 1) {
            if (nums[i] < nums[i + 1]) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i + 1]);
            } else {
                min = Math.min(min, nums[i + 1]);
                max = Math.max(max, nums[i]);
            }
            i += 2;
        }
        return new int[]{min, max};
    }
}
