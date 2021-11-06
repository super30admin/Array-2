// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            int index = Math.abs(nums[i]) - 1;
            
            if (nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] > 0) {
                missingNumbers.add(i+1);
            }
        }
        return missingNumbers;
    }
}