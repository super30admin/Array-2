import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Time Complexity : O (n)
 * Space Complexity : O (1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : no
 *
 * Approach:
 *
 * - For each number, calculate its corresponding index (Math.abs(nums[i]) - 1).
 * - Mark the element at that index as negative to indicate that the number (index + 1) is present in the array.
 * - Any index with a positive value indicates that the number (index + 1) is missing from the input.
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        // Marking indices corresponding to present numbers
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Collecting indices that remain positive
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
            // Restoring the array (optional, if no side effects allowed)
            nums[i] = Math.abs(nums[i]);
        }

        return result;
    }


    public static void main(String[] args) {
        FindDisappearedNumbers obj = new FindDisappearedNumbers();
        int[] nums = {3,2,4,6,7,1,8,1};
        List<Integer> disappearedNumbers = obj.findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
        assert(Objects.equals(disappearedNumbers, List.of(5)));
    }
}
