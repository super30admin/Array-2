// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :No

public class FindMinMax {
    public static int[] findMinMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int min, max;
        int i = 0;

        // If odd number of elements, initialize min and max with the first element
        if (nums.length % 2 != 0) {
            min = max = nums[0];
            i = 1; // Start from second element
        } else { 
            // If even, initialize with the first two elements
            if (nums[0] < nums[1]) {
                min = nums[0];
                max = nums[1];
            } else {
                min = nums[1];
                max = nums[0];
            }
            i = 2; // Start from third element
        }

        // Compare elements in pairs
        while (i < nums.length - 1) {
            if (nums[i] < nums[i + 1]) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i + 1]);
            } else {
                min = Math.min(min, nums[i + 1]);
                max = Math.max(max, nums[i]);
            }
            i += 2; // Move to next pair
        }

        return new int[]{min, max};
    }

    
}