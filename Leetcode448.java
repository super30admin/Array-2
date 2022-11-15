import java.util.ArrayList;
import java.util.List;

public class Leetcode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {// this to handel the case when the elements are duplicate and if make and if we
                                  // multipply it with -1 again it will become postive and that will wrong
                                  // answrer.
                nums[index] = nums[index] * -1;
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}

// time comlexity--> O(n)
// space comlexity--> O(1)