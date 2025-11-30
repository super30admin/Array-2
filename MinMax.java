import java.util.Arrays;

// Approach: Minimizing number of comparisions to approximately 1.5 comparisions per index.
// Time complexity: N/2 ~= O(N)
// Space complexity: O(1)

public class MinMax {
    public int[] findMinMax(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("No solution: Array is empty");
        }
        int min = nums[0];
        int max = nums[0];
        int index = 1;
        for (; index < nums.length; index += 2) { // increment 2 indices
            if (nums[index - 1] < nums[index]) {
                min = Math.min(min, nums[index - 1]); // compare min with smaller number
                max = Math.max(max, nums[index]); // compare max with larger number
            } else {
                max = Math.max(max, nums[index - 1]); // compare max with larger number
                min = Math.min(min, nums[index]); // compare min with smaller number
            }
        }
        if (index == nums.length) {
            // Handle last index
            min = Math.min(min, nums[nums.length - 1]);
            max = Math.max(max, nums[nums.length - 1]);
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        MinMax ob = new MinMax();
        int[] nums1 = {3, 1, 0, 9, 4, 6};
        System.out.println(Arrays.toString(ob.findMinMax(nums1))); // returns [0, 9]
        int[] nums2 = {3};
        System.out.println(Arrays.toString(ob.findMinMax(nums2))); // returns [3, 3]
        int[] nums3 = {3, 1};
        System.out.println(Arrays.toString(ob.findMinMax(nums3))); // returns [1, 3]
        int[] nums4 = {3, 1, 0, 9};
        System.out.println(Arrays.toString(ob.findMinMax(nums4))); // returns [0, 9]
        int[] nums5 = {-1};
        System.out.println(Arrays.toString(ob.findMinMax(nums5))); // returns [-1, -1]
        int[] nums6 = {3, -1};
        System.out.println(Arrays.toString(ob.findMinMax(nums6))); // returns [-1, 3]
        int[] nums7 = {-1, -3, -2};
        System.out.println(Arrays.toString(ob.findMinMax(nums7))); // returns [-3, -1]
        int[] nums8 = {-1, 7, -3, -2, 3};
        System.out.println(Arrays.toString(ob.findMinMax(nums8))); // returns [-3. 7]
        int[] nums9 = {};
        System.out.println(Arrays.toString(ob.findMinMax(nums9))); // throws exception with message "No solution: Array is empty"
    }
}
