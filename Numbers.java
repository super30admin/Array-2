// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;

class Numbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums ==  null || nums.length == 0) return list;
        for (int i = 0; i < nums.length; i++) {
            int l = Math.abs(nums[i]) - 1;
            if (nums[l] > 0) {
                nums[l] *= -1;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}