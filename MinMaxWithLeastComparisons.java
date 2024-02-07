// TC - O(N/2)
// SC - O(1)
// Comparisons - (3N/2)

// Constraints
// 1 <= N <= 10^5
// -10^9 <= nums[i] <= 10^9

public class MinMaxWithLeastComparisons {
    // public int[] getMinMax(int[] nums) {
    public int getMinMax(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] < nums[i + 1]) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i + 1]);
            } else {
                min = Math.min(min, nums[i + 1]);
                max = Math.max(max, nums[i]);
            }
        }

        if (nums.length % 2 != 0) {
            min = Math.min(min, nums[nums.length - 1]);
            max = Math.max(max, nums[nums.length - 1]);
        }

        // return new int[] { min, max };
        return min + max;
    }
}
