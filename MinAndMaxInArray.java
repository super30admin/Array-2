// Number of Comparisons : 1.5n
public class MinAndMaxInArray {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 1, 0, 3, 2, -1, 5 };
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] > nums[i + 1]) {
                maxValue = Math.max(maxValue, nums[i]);
                minValue = Math.min(minValue, nums[i + 1]);
            } else {
                maxValue = Math.max(maxValue, nums[i + 1]);
                minValue = Math.min(minValue, nums[i]);
            }
        }
        System.out.println("Max Value :: " + maxValue);
        System.out.println("Min Value :: " + minValue);
    }
}
