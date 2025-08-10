# Array-2

## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

// Time Complexity : O(n)   
// Space Complexity : O(1) (excluding the output list)    
// Did this code successfully run on Leetcode : Yes  
// Any problem you faced while coding this :   

// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // make all traversed elements index as -ve to mark them as visited
        List<Integer> result = new ArrayList<>();

        // First pass: mark visited indices as negative
        for (int i = 0; i < nums.length; i++) {
            int absN = Math.abs(nums[i]); // get the original value 
            int idx = absN - 1;           
            if (nums[idx] > 0) {          // if not yet visited
                nums[idx] = nums[idx] * -1; // mark as visited
            }
        }

        // Second pass: indices with positive values were never visited
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // map index back to value
            }
        }
        return result;
    }
}
