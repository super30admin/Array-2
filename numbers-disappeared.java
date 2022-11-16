import java.util.*;

//time complexity O(n)
//space complexity O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {

            int num = Math.abs(nums[i]) - 1;

            if (nums[num] > 0) {
                nums[num] = -1 * nums[num];
            }

        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num > 0) {
                res.add(i + 1);
            } else {
                // just to bring the original array back
                nums[i] *= -1;
            }
        }

        return res;

    }
}
