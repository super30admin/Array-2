// Time Complexity : O (1.5 n) => O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class Solution {

    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public void getMinMax(int[] nums) {

        int n = nums.length;
        int start = 0;

        // If n is odd
        if (n % 2 == 1) {
            min = nums[0];
            max = nums[0];
            start = 1;
        }

        // compare using pair method
        // Comparisons = 3 * n/2 = 1.5n
        for (int i = start; i < n; i += 2) {
            if (nums[i] > nums[i + 1]) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i + 1]);
            } else {
                max = Math.max(max, nums[i + 1]);
                min = Math.min(min, nums[i]);
            }
        }


    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5};

        Solution s = new Solution();
        s.getMinMax(nums);

        System.out.println("Min ==>" + min);
        System.out.println("Max ====> " + max);

    }


}