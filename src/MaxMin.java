/*
Problem -  An array of numbers of length N is given , you need to find the minimum and maximum. try doing this in less than 2* (N-2) comparisons
Approach - We compare the first one or two elements to initialize the min and max.
Then we scan the array in pairs and update min and max by comparing within the pair first.
•This reduces the number of comparisons to about 1.5 * n, making it efficient.
 */

import java.util.Arrays;

public class MaxMin {
    public int[] findMinAndMax(int[] nums) {
            int n = nums.length;
            int min, max;
            int i;
            // Handle first pair (or first element if odd length)
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

            // Process pairs
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
    public static void main(String[] args) {
        MaxMin obj = new MaxMin();
        System.out.println(Arrays.toString(obj.findMinAndMax(new int[]{3, 5, 4, 1, 9})));
        System.out.println(Arrays.toString(obj.findMinAndMax(new int[]{22, 14, 8, 17, 35, 3})));
    }
}
