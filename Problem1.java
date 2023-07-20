//Time complexity: O(n)
//Space complexity: O(n)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        List<Integer> missingNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int num = 1; num <= nums.length; num++) {

            if (!set.contains(num)) {
                missingNumbers.add(num);
            }

        }
        return missingNumbers;
    }
}