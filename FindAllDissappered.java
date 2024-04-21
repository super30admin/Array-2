// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.*;;

public class FindAllDissappered {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] cache = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cache[nums[i] - 1] = nums[i];
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] == 0) {
                result.add(i + 1);
            }
        }

        return result;

    }
}