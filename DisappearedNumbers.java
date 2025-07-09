// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
// Example 1:
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]

// Example 2:
// Input: nums = [1,1]
// Output: [2]
 
// Constraints:
// n == nums.length
// 1 <= n <= 105
// 1 <= nums[i] <= n
 
// Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Base Case: input array is null or empty
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1; // Getting index for the number
            if (nums[index] > 0){
                nums[index] = nums[index] * -1; // Marking as negative to indicate presence
            }
        }

        // Finding the missing numbers
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){ // Checking if number is still positive, then it was missing
                result.add(i + 1); // Adding the missing number (index + 1)
            }
        }

        // Returning the result list
        return result;
    }
}