import java.util.ArrayList;
import java.util.List;
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english
/*
change the corresponding index as negative and then traverse the full array once.
after that traverse again and o/p the result to list of index that has +ve number
 */
// Your code here along with comments explaining your approach
public class FindDisappearedNumber {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>(nums.length+1);
            int count = 0;
            for(int i=0; i<nums.length; i++) {
                int index = Math.abs(nums[i]) - 1;
                if(nums[index]>0) {
                    nums[index] = nums[index] * -1;
                }
            }
            // find the disappeared number
            for(int i=0; i<nums.length; i++) {

                if(nums[i] > 0) {
                    result.add(i+1);
                }
                else {
                    nums[i] = nums[i] * -1;
                }
            }
            return result;
        }
}
