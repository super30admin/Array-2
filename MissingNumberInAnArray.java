import java.util.*;
// Time Complexity : O(n)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach -:

The fact is arr is having the size n, and it contains the numbers in the range [1 to n]
while iterating over the array, I take the value in the particular index and take offset
which Math.abs(nums[i]) - 1 (points to that particular index in the array). At that index,
we turn the value into negative (which confirms the existence of that number)

abs is used to handle an index that the value is already turned into a negative value

After we perform that operation, iterate over the array and check if the index is having
+ve or -ve value, if it is negative we know that corresponding index exists somewhere in the
array, if it is +ve, that is the missing number
 */
public class MissingNumberInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        if(nums == null || nums.length == 0) return null;

        List<Integer> result = new ArrayList<>();

        int offset = 0;

        for(int i = 0; i < nums.length; i++) {
            offset = Math.abs(nums[i]) - 1;

            if(nums[offset] < 0) {
                continue;
            }
            nums[offset] *= -1;
        }

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
