/*
* Approach:
*  1. Missing numbers can be found using hashset of size 1 to n.
*       but this will increase space complexity to O(n).

*  2. Therefore, lets maintain hashset in the same input array,
        by turning the numbers into negative.

        As range is from 1 to n.
* 
*  3. Iterate over the array values,
        and turn the values in the specified index into negative.
    Finally, indices+1 which are positive are missing numbers.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n) + O(n) === O(n)
* 
* Space Complexity: O(1)
* 
*/
import java.util.ArrayList;
import java.util.List;

public class MissingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int index = 0; index < nums.length; index++) {
            int element = Math.abs(nums[index]) - 1;

            if (nums[element] > 0)
                nums[element] = -nums[element];
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] > 0)
                result.add(index);
        }

        return result;
    }
}
