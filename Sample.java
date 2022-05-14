// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


import java.util.ArrayList;
import java.util.List;

// Your code here along with comments explaining your approach
class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> disappearedNumbers = new ArrayList<>();

        // Make the corresponding number at the ith place negative signifying it is found..
        // if some non negative numbers are the ones which are not present in the array
        for (int i = 0; i < nums.length; i++) {
            int numberAti = Math.abs(nums[i]);
            if (nums[numberAti - 1] > 0) {
                nums[numberAti - 1] = -nums[numberAti - 1];
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                disappearedNumbers.add(j + 1);
            }
        }
        return disappearedNumbers;
    }
}
