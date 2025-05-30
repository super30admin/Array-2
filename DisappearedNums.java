import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DisappearedNums {
    // ------------------------ Solution 1 ---------------------
    /**
     * Use Set to find if a number is missing in constant time to improve on
     * nested iteration brute force solution
     *
     * Time: O(n) Space: O(n)
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        List<Integer> resultList = new ArrayList<>();

        for (int n: nums) {
            numSet.add(n);
        }

        for(int i = 1; i <= nums.length; i++) {
            if (!numSet.contains(i)) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    // ------------------------ Solution 2 --------------------------
    /**
     * In-place temporary state change solution to mark presence of a given number
     * to an index in array (here index = val - 1). In second pass identify positive values
     * and mark its corresponding index missing (missing  = index + 1)
     *
     * Time: O(n) Space: O(1)
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> resultList = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            if (nums[n - 1] > 0) {
                nums[n - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] *= -1;
            } else {
                resultList.add(i + 1);
            }
        }
        return resultList;
    }
}
