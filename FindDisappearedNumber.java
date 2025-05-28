// Time Complexity: O(n)
// Space Complexity: O(1)
// Runs on LeetCode: YES
import java.util.ArrayList;
import java.util.List;

class FindDisappearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int index;
            if (nums[i] < 0) {
                index = (nums[i] * -1) - 1;
            } else {
                index = nums[i] - 1;
            }
            if (nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = nums[i] * -1;
            } else {
                result.add(i + 1);
            }
        }
        return result;
    }
}
