import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TC - O(N*N)
// SC - O(1)

// Constraints:
// n == nums.length
// 1 <= n <= 10^5
// 1 <= nums[i] <= n

public class DisappearedNumbersSort {
    class Solution {
        // [1 1]
        // [1 2 2 3 3 4 7 8]
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> resultList = new ArrayList<>();
            Arrays.sort(nums);
            int expected = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < expected) {
                    expected--;
                } else if (nums[i] > expected) {
                    resultList.add(expected);
                    i--;
                }
                expected++;
            }
            while (expected <= nums.length) {
                resultList.add(expected);
                expected++;
            }
            return resultList;
        }
    }
}