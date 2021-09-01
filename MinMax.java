// Time Complexity : O(n)
// Space Complexity : O(1)

// Your code here along with comments explaining your approach
/**
 * Goal is to reduse the number of comparisons So we need to take pairs of
 * numbers and compair them if they are greater or lesser the resultent must be
 * compared to global min max so that the number of comparisions will be redused
 * by 25%
 */
public class MinMax {
    public void printMinMax(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i = i + 2) {
            if (nums[i] < nums[i + 1]) {
                min = Math.min(nums[i], min);
                max = Math.max(nums[i + 1], max);
            } else {
                max = Math.max(nums[i], max);
                min = Math.min(nums[i + 1], min);
            }
        }
        if (nums.length % 2 == 1) {
            max = Math.max(nums[nums.length - 1], max);
            min = Math.min(nums[nums.length - 1], min);
        }

        System.out.println(min + ", " + max);
    }

    public static void main(String[] args) {
        int arr[] = { 1000, 11, 445, 1, 330, 3000 };
        int arr_size = 6;
        MinMax mm = new MinMax();
        mm.printMinMax(arr);
    }
}
