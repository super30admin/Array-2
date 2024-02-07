import java.util.ArrayList;
import java.util.List;

// TC - O(N)
// SC - O(1)

// Constraints:
// n == nums.length
// 1 <= n <= 10^5
// 1 <= nums[i] <= n

// [4 3 2 7 8 2 3 1]
// [0 1 2 3 4 5 6 7]
// [-4 -3 -3 -7 8 2 -3 -1]
public class DisappearedNumbersOptimal {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> resultList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int value = Math.abs(nums[i]);
                if (nums[value - 1] > 0) {
                    nums[value - 1] *= -1;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    resultList.add(i + 1);
                }
            }
            return resultList;
        }
    }
}