// Time Complexity : O(n) with n comparisons
// Space Complexity : O(1)

// Your code here along with comments explaining your approach
/*
Maintain min and max variables to track min and max values of array. now, compare consecutive elements to
find min and max between them and assign them to min and max values if applicable.This way, we can avoid
extra comparisons.This way, we can iterate every i+2 elements until end of array. To balance this check in
odd length arrays, we initialize the iterating i pointer accordingly.
 */
public class MaxandMinOfArray {
    public static int[] findMaxAndMin(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i = 0;

        if(n % 2 == 0) {
            if(nums[0] < nums[1]) {
                min = Math.min(min, nums[0]);
                max = Math.max(max, nums[1]);
            }
            else {
                min = Math.min(min, nums[1]);
                max = Math.max(max, nums[0]);
            }
            i = 2;
        }
        else {
            min = max = nums[0];
            i = 1;
        }
        while(i < n - 1) {
            if(nums[i] <  nums[i + 1]) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i + 1]);
            }
            else {
                min = Math.min(min, nums[i + 1]);
                max = Math.max(max, nums[i]);
            }
            i = i + 2;
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3 , 1};
        int[] minMax = findMaxAndMin(arr);
        System.out.println("Minimum element is " + minMax[0] + " and maximum element is " + minMax[1]);
    }
}