// Problem 448. Find All Numbers Disappeared in an Array
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.List;

class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1; // Get the index for the number
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // Negate the value at this index
            }
        }
        List<Integer> missingNumbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missingNumbers.add(i + 1);
            }else{
                nums[i] = -nums[i]; // Get back the original Array
            }
        }
        return missingNumbers;
    }
}
