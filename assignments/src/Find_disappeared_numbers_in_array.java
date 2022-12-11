import java.util.LinkedList;
import java.util.List;

public class Find_disappeared_numbers_in_array {
    // Time: O(n), Space: O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i<nums.length; i++) {
            int newIndx = Math.abs(nums[i]) - 1;

            if (nums[newIndx] > 0) {
                nums[newIndx] *= -1;
            }
        }
        List<Integer> ans = new LinkedList();

        for (int i = 0; i<nums.length; i++) {
            if(nums[i] > 0) {
                ans.add(i+1);
            }
        }
        return ans;
    }
}
