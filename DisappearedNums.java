// In this we know that numbers are from 1 to n and indices of those are 0 to n-1, hence difference is 1. 
// So, here we will subtract each by 1 (eg. 4-1=3)and go to that index and make the number over there as negative(-7), 
// indicating the current number(4) is present. In the end, iterate through nums again and if any number is positive, 
// (index of that number + 1) is missing. Add index+1 in result array.

// Time Complexity : O(n)
// Space Complexity : O(1) - mutating original
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Checking base case
        if (nums.length == 0 || nums == null) {
            return new ArrayList<>();
        }
        int n = nums.length;
        // Declaring result list
        List<Integer> result = new ArrayList<>();
        // Iterating through the array for making all the values negative at that index
        // if they are present
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }
        // Again iterating to check if any value is positive that means at that position
        // the value is missing (index+1) value
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                // Adding i+1 to result array
                result.add(i + 1);
            } else {
                // Else just changing the negative to positive again, so that the original array
                // is as is
                nums[i] = nums[i] * -1;
            }
        }
        // Return result
        return result;
    }
}