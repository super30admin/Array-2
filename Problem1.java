import java.util.ArrayList;
import java.util.List;

//Time Complexity O(n)
// Space Complexity O(1)
public class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int value = Math.abs(nums[i]) - 1;
            if (nums[value] > 0) {
                nums[value] = nums[value] * -1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
                //nums[i] = nums[i] * -1;
            }
        }
        return result;
    }

}
