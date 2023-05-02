// Time Complexity : O(n)
// Space Complexity : O(1)

public class Solution {
    public int[] findMaxAndMin(int[] nums) {
        if(nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }
        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i+=2) {
            if(nums[i] > nums[i-1]) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i-1]);
            }
            else {
                max = Math.max(max, nums[i+1]);
                min = Math.min(min, nums[i]);
            }
        }
        if(nums.length % 2 != 0) {
            max = Math.max(max, nums[nums.length - 1]);
            min = Math.min(min, nums[nums.length - 1]);
        }

        return new int[]{max, min};
    }