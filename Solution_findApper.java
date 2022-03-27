/*

Time :  O(n)
Space : O(1)
*/
import java.util.*;

class Solution_findApper {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int temp = Math.abs(nums[i]) - 1;

            if (nums[temp] > 0) {

                nums[temp] *= -1;

            }
        }

        for (int i = 0; i < n; i++) {

            if (nums[i] > 0) {

                list.add(i + 1);
            }

        }

        return list;
    }

}
