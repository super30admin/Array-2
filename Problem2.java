public class Problem2 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5 };
        int n = nums.length;
        findMinMax(nums, n);
    }

    public static void findMinMax(int[] nums, int n) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }
}
