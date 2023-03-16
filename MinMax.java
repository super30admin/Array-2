/*the time complexity of this implementation is O(n)*/
public class MinMax {
    public static int[] findMinMax(int[] nums) {
        int n = nums.length;
        int[] result = new int[2];

        // Handle the case where the array has only one element
        if (n == 1) {
            result[0] = nums[0];
            result[1] = nums[0];
            return result;
        }

        // Initialize the tournament with the initial pairs of adjacent elements
        int[] winners = new int[n / 2];
        for (int i = 0; i < n; i += 2) {
            if (nums[i] < nums[i + 1]) {
                winners[i / 2] = nums[i];
            } else {
                winners[i / 2] = nums[i + 1];
            }
        }

        // Recursively find the minimum and maximum of the winners
        int[] subResult = findMinMax(winners);
        result[0] = subResult[0];  // minimum
        result[1] = subResult[1];  // maximum

        // Compare the remaining elements to the minimum and maximum so far
        for (int i = 0; i < n; i++) {
            if (nums[i] < result[0]) {
                result[0] = nums[i];
            } else if (nums[i] > result[1]) {
                result[1] = nums[i];
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 8, 4, 9, 2, 6};
        int[] result = findMinMax(nums);
        System.out.println("Minimum value: " + result[0]);
        System.out.println("Maximum value: " + result[1]);
    }
}
