import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(n)
//Space Compelxity: O(1)
//Leetcode: yes.
public class FindDisappearedNumberLeetcode448 {

        public List<Integer> findDisappearedNumbers(int[] nums) {

            if (nums == null) {
                return new ArrayList<>();
            }

            List<Integer> result = new ArrayList<Integer>();
            //we can use hashset here but the question wants constant space
            //so take the current number and treat that as index and convert the number
            //at that index to -ve number
            for (int i = 0; i < nums.length; i++) {

                int new_index = Math.abs(nums[i]) - 1;

                if (nums[new_index] > 0) {
                    nums[new_index] *= -1;
                }
            }
            //now if any number is positive that index is the missing number.
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    result.add(i + 1);
                }
            }

            return result;
        }
}
