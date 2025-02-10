
// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
import java.util.ArrayList;
import java.util.List;

public class FindMissingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] > 0 ? nums[i] : (nums[i] * (-1));
            nums[index - 1] = nums[index - 1] * (nums[index - 1] > 0 ? -1 : 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;

    }
}