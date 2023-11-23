
/*
Time : 0(N)
Space: 0(1)
 */

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {

  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {

      if (nums[Math.abs(nums[i]) - 1] > 0) {

        nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] * -1;

      }
    }

    for (int i = 0; i < nums.length; i++) {

      if (nums[i] < 1) {
        nums[i] = nums[i] * -1;
      } else {

        ans.add(i + 1);

      }
    }

    return ans;

  }

}
