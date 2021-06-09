package Array2;

import java.util.Arrays;

public class question32_minMaxInArray {

    /*
        Using Arrays.sort method
            Time Complexity: O(n log n)
            Space Complexity: O(1)
     */
    private static void getMinMaxSortArray(int[] nums) {
        Arrays.sort(nums);
        System.out.println("Minimum Element in the array: " + nums[0]);
        System.out.println("Maximum Element in the array: " + nums[nums.length - 1]);
    }

    /*
    Using two variable for max and min
        Time Complexity: O(2n), at each step, there are two comparisions each for max and min element.
        Space Complexity: O(1)
     */
    private static void getMinMaxUsingInteger(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        System.out.println("Minimum Element in the array: " + min);
        System.out.println("Maximum Element in the array: " + max);
    }

    /*
        Time Complexity: O(1.5 n)
        Space Complexity: O(1)
     */
    private static void getMinMaxUsing3Comparisions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length - 1 ; i++) {
            if(nums[i] > nums[i + 1]) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i + 1]);
            } else {
                max = Math.max(max, nums[i + 1]);
                min = Math.min(min, nums[i]);
            }
        }
        System.out.println("Minimum Element in the array: " + min);
        System.out.println("Maximum Element in the array: " + max);
    }

    public static void main(String[] args) {
        int nums[] = {1000, 11, 445, 1, 330, 3000};
        getMinMaxSortArray(nums);
        getMinMaxUsingInteger(nums);
        getMinMaxUsing3Comparisions(nums);
    }
}
