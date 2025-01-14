// Time Complexity : O (n)
// Space Complexity : O (n)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

// Your code here along with comments explaining your approach
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // use a boolean array to keep track of seen nums
        boolean[] seen = new boolean[nums.length + 1];
        // mark indices of all nums in the array as seen
        for (int n : nums) {
            seen[n] = true;
        }
        // add non-seen numbers in the array (false) to the result
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if(!seen[i]) result.add(i);
        }
        return result;
    }
}