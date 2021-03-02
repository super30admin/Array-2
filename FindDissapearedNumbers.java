// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.ArrayList;
import java.util.List;

public class FindDissapearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }
}