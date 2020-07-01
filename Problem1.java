/* Disappeared numbers */

// Time Complexity : O(N)
// Space Complexity : O(1) in place
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//Here we will consider in place algorithm where we will mutate the array
//Start iterating from first index, and find corresponding index for each value
//Change the value to negative for that corresponding index
//at the end, find the numbers that are left positive in the array-missing numbers

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        //edge case
        if(nums == null || nums.length == 0) return result;
        //Case-mutate the array with making positive values(corresponding to index) as negative
        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0) nums[idx] *= -1;
        }
        //Return the result by adding to arraylist all the left positive values-missing numbers
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) result.add(i+1);
        }
        return result;
    }
}