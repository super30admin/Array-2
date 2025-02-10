/*
 * ## Problem2
Given an array of numbers of length N, find both the minimum and maximum. 
Follow up : Can you do it using less than 2 * (N - 2) comparison
 */
// Time Complexity :O(N)
// Space Complexity :(1)
// Did this code successfully run on Leetcode :N/A
// Any problem you faced while coding this :No
public class MinimumMaximum {
    public int[] FindMinMax(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        int[] res = new int[2];
        int n = nums.length;

        if (n % 2 == 0) {
            res[0] = Math.max(nums[0], nums[1]);
            res[1] = Math.min(nums[0], nums[1]);
        } else {
            res[0] = nums[0];
            res[1] = nums[0];
        }

        for (int i = (n % 2 == 0 ? 2 : 1); i < n - 1; i = i + 2) {
            if (nums[i] > nums[i + 1]) {
                res[0] = Math.max(nums[i], res[0]);
                res[1] = Math.min(nums[i + 1], res[1]);
            } else {
                res[0] = Math.max(nums[i + 1], res[0]);
                res[1] = Math.min(nums[i], res[1]);
            }
        }
        return res;
    }
}