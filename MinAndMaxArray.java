// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// problem statement: Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

// Approach

/**
 * In this problem, I have used the approach to compare the elements of the array in pairs.
 */

class MinMaxArray {
    public static void main(String[] args) {
        int[] nums = {9,1,6,2,6,26,12};

        int[] result = minMaxArray(nums);

        System.out.println("Min: "+result[0]);
        System.out.println("Max: "+result[1]);
    }

    private static  int[] minMaxArray(int[] nums) {
        int[] result = new int[2];

        int min = nums[0], max = nums[0], i = 0;

        // if there is only one element
        if (nums.length % 2 == 1) {
            max = nums[0];
            min = nums[0];

            i = 1;
        } else if (nums.length % 2 == 0) {
            max = nums[0];
            min = nums[1];

            i = 2;
        }

        // compare in pairs
        while (i < nums.length - 1) {
            if (nums[i] > nums[i+1]) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i+1]);
            } else {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i+1]);
            }

            i++;
        }

        result[0] = min;
        result[1] = max;

        return result;
    }
}