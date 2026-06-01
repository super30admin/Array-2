//Time Complexity : O(n)
//Space Complexity : O(1)

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    List<Integer> result;
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        for(int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] *= -1;
            } else {
                result.add(i + 1);
            }
        }
        return result;
    }
}
