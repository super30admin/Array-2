import java.util.ArrayList;
import java.util.List;

// TC - O(N*N)
// SC - O(1)

// Constraints:
// n == nums.length
// 1 <= n <= 10^5
// 1 <= nums[i] <= n

public class DisappearedNumbersBrute {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> resultList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int j = 0;
                for (j = 0; j < nums.length; j++) {
                    if (nums[j] == i + 1) {
                        break;
                    }
                }
                if (j == nums.length) {
                    resultList.add(i + 1);
                }
            }
            return resultList;
        }
    }
}