// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();

        // for loop for traversing in nums array
        for (int i = 0; i < nums.length; i++) {

            // here we multiply visited index by -1 if any index is positive that means that
            // is the missing numbers

            // here we also check nums[i] is less then nums.length or else it will give
            // index out of bound error
            if (Math.abs(nums[i]) <= nums.length && nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        // System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            // if nums[i] > 0 we add index + 1 into result list
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println("missing numbers in the array is: " + findDisappearedNumbers(nums));
    }
}