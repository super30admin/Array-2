// Time Complexity : O(n) due to iterating through the array twice
// Space Complexity :   O(1) if we don't consider the output list, otherwise O(n) for the output list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The problem is to find all the numbers in the range [1, n] that are missing from the input array.
// The approach is to use the input array itself to mark the presence of numbers.
// We iterate through the input array and for each number, 
// we calculate its corresponding index (num)   
// and mark the number at that index as negative to indicate that the number (num) is present in the array.
// After marking the presence of numbers, we iterate through the input array again and collect the indices that are still positive.
// These indices correspond to the missing numbers in the range [1, n] and we add them to the result list. 
// Finally, we return the result list containing all the missing numbers
import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;

        // mark visited indices
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int idx = Math.abs(num) - 1;

            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        List<Integer> result = new ArrayList<>();

        // collect missing numbers
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}