// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.ArrayList;
import java.util.List;

public class FindAllNumberDisappearedInArray {
    public List<Integer> FindAllNumberDisappearedInArray(int[] nums) {
        int temp = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;

        // Mark the visited element by Multiplying with -1
        for (int i = 0; i <= n - 1; i++) {
            temp = Math.abs(nums[i]);
            if (nums[temp - 1] > 0) {
                nums[temp - 1] *= -1;
            }
        }
        //Storing back the original array and adding the positive element in the array list
        for (int i = 0; i <= n - 1; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            } else {
                nums[i] *= -1;
            }
        }

        return list;
    }
}
