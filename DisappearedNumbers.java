// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class DisapearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            
            int index = Math.abs(nums[i]) - 1;
            
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                nums[i] *= -1;
                result.add(i+1);
            }
        }
        
        return result;
    }
}