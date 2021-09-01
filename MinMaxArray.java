// TIME: O(n)
// SPACE: O(1)
// COMPARISIONS: O(n)

public class MinMaxArray {
    public int[] minMax(int[] nums) {
        int min = Math.min(nums[0], nums[1]);
        int max = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
        }

        return new int[]{min, max};
    }
}
