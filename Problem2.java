## Problem2
Given an array of numbers of length N, find both the minimum and maximum. 
Follow up : Can you do it using less than 2 * (N - 2) comparison

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : Needed to handle odd and even length arrays separately

class Solution {
    public int[] findMinMax(int[] nums) {
        int min, max;
        int i;

        // Initialize
        if (nums.length % 2 == 0) {
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

        // Compare in pairs
        while (i < nums.length - 1) {
            if (nums[i] < nums[i + 1]) {
                if (nums[i] < min) 
                    min = nums[i];
                if (nums[i + 1] > max) 
                    max = nums[i + 1];
            } else {
                if (nums[i + 1] < min) 
                    min = nums[i + 1];
                if (nums[i] > max) 
                    max = nums[i];
            }
            i += 2;
        }

        return new int[]{min, max};
    }
}
