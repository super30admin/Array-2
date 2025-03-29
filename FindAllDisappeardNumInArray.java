import java.util.ArrayList;
import java.util.List;

public class FindAllDisappeardNumInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;

            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            } else {
                nums[i] *= -1;
            }
        }

        return res;
    }
}

/**
 * TC: O(2n) = O(n)
 * SC: O(1)
 */