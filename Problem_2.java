// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We store first element in min and mx variable. Then we iterate and compare subsequent values and keep on updating max and 
   min till we complete iterating the array.
*/

public class Problem2 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5 };
        int n = nums.length;
        findMinMax(nums, n);
    }

    public static void findMinMax(int[] nums, int n) {
        int min = nums[0], max = nums[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }
}