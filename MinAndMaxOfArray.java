import java.util.Arrays;

public class MinAndMaxOfArray {
    public static void main(String[] args) {
        int[] nums = {0,12222,4,53,6,2,54,76,33,65,12,134235};
        int[] res = getMinMax(nums);
        System.out.println(Arrays.toString(res));
    }

    // TC: O(N) where N is length of nums
    // SC: O(1)
    private static int[] getMinMax(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = nums.length;

        for (int i = 0; i < n - 1; i = i + 2) {
            if (nums[i] < nums[i + 1]) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i + 1]);
            } else {
                min = Math.min(min, nums[i + 1]);
                max = Math.max(max, nums[i]);
            }
        }

        if (n % 2 != 0) {
            min = Math.min(min, nums[n - 1]);
            max = Math.max(max, nums[n - 1]);
        }
        return new int[]{min, max};
    }
}


