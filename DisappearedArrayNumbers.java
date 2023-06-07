// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.List;

public class DisappearedArrayNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();

        // Iterate over each of the elements in the original array
        for (int i = 0; i < nums.length; i++) {
            // Treat the value as the new index
            int newIndex = Math.abs(nums[i]) - 1;
            // Check the magnitude of value at this new index. If the magnitude is positive,
            // make it negative thus indicating that the number nums[i] has appeared or has
            // been visited.
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }

        }

        // Response array that would contain the missing numbers
        // List<Integer> result = new LinkedList<Integer>();

        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the answer
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = { 4, 3, 2, 7, 8, 2, 3, 1 };
        DisappearedArrayNumbers obj = new DisappearedArrayNumbers();
        System.out.println("Disappeared Numbers are: " + obj.findDisappearedNumbers(input));
    }
}