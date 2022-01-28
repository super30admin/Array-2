import java.util.*;

public class MaxMin {

    // nums = [-3,-5,5,2,3,7];

    public List<Integer> maxMin(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > nums[i + 1]) {
                max = Math.max(nums[i], max);
                min = Math.min(nums[i + 1], min);
            } else {
                max = Math.max(nums[i + 1], max);
                min = Math.min(nums[i], min);
            }
        }
        return ans;
    }
}
