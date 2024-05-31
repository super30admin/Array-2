// Time Complexity : O(2N) = O(N) => As we have 2 for loops iterating over all the elements in the array
// Space Complexity : O(1) => Even though we are creating a new array list but we are returning that same array list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Start traversing from the elements and subtract -1 from the element and go to that index and negate the value to indicate we have found the matching index and value.
Once done, again traverse through the entire array to find positive values which indicates that index was never visisted and hence the element is missing in the array.
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        if (nums.length == 0 || nums == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        // Negate the array elements to indicate that index was found
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Subtracting -1 as index starts from 0 but elements starts from 1

            if (nums[index] > 0) {
                nums[index] = nums[index] * (-1);
            }
        }

        for (int i = 0; i < nums.length; i++) {

            //Since in the above for loop we were mutating the original array we are multiplying by -1 to get the original matrix
            if (nums[i] < 0) {
                nums[i] = nums[i] * (-1);
            } else {
                result.add(i + 1);
            }
        }
        return result;
    }
}