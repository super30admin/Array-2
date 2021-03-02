import java.util.ArrayList;
import java.util.List;
// Time Complexity : O(n); n = #elements in array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


public class DisappearingElements {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val - 1] > 0)
                nums[val - 1] *= -1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                res.add(i + 1);
        }
        return res;
    }
}
