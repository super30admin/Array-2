// Time Complexity :O(N)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// The idea is to find the missing numbers from 1 to N range without using additional space.
// So need to perform operation on the given array. How to say that a particular value is present in the array?
// I can do that by marking the value at arr[value] as negative, to say that this particular index value is present
// in the given array. Then I traverse the array again and check if the value at that index is not negative, it means
// that index value is not present in the array. and I store in result list.

import java.util.ArrayList;
import java.util.List;

public class DissapperedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp < 0) {
                temp *= -1;
            }

            if (nums[temp - 1] > 0) {
                nums[temp - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
