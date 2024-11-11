// Time complexity O(n)
// Space complexity O(1)
//Ran on leetcode: yes
// Any problem occured : No
import java.util.ArrayList;
import java.util.List;

public class MissingNumberInArray {
    public List<Integer> findMissigNumber(int [] nums){
        List<Integer> result = new ArrayList<>();
        // Mark numbers as negative to indicate their presence
            for (int i = 0; i < nums.length; i++) {
                 int idx = Math.abs(nums[i]) - 1;  // get the correct index
                if (nums[idx] > 0) {  // mark as negative if not already
                        nums[idx] = -nums[idx];
                }
            }

        // Step 2: Collect indices that have positive values
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {  // positive index means number (i+1) is missing
                    result.add(i + 1);
                }
            }

        // Step 3 (optional): Restore the original array
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Math.abs(nums[i]);
            }

            return result;
        }
    public static void main (String[] args){
        MissingNumberInArray solution = new MissingNumberInArray();
        int [] nums = {4,3,2,7,8,2,3,1};
        System.out.println(solution.findMissigNumber(nums));

    }
}
