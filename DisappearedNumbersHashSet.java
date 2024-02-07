import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// TC - O(N)
// SC - O(N)

// Constraints:
// n == nums.length
// 1 <= n <= 10^5
// 1 <= nums[i] <= n

public class DisappearedNumbersHashSet {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> resultList = new ArrayList<>();
            Set<Integer> numberSet = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                numberSet.add(nums[i]);
            }

            for (int i = 1; i <= nums.length; i++) {
                if (!numberSet.contains(i)) {
                    resultList.add(i);
                }
            }
            return resultList;
        }
    }
}