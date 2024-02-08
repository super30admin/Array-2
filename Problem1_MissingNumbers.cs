// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
public class Solution {
    public IList<int> FindDisappearedNumbers(int[] nums) {
        var result = new List<int>();
        for(int i = 0; i < nums.Length; i++) { 
            //Mark the number at position (nums[i] - 1) negative,
            //to know that the number i + 1 exists in the array.
            if(nums[i] != i+1) {
                int index = Math.Abs(nums[i]) - 1;
                nums[index] = Math.Abs(nums[index]) * -1;
            }
        }
        for(int i = 0; i < nums.Length; i++) {
            // If the number at index i is not marked as negative,
            // then the number i+1 is missing in the array.
            if(nums[i] > 0 && nums[i] != i+1) {
                result.Add(i+1); // Add missing number to the result list
            }
        }
        return result;
    }
}
