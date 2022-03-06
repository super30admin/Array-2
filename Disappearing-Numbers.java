import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach :
// marking elements as -ve
// going to the index of -ve marked element and marking -ve again and repeat
// finally, the elements that are not -ve are the missing numbers
// so return INDEX + 1, index because thats the element(s) that should be missing


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> res = new ArrayList<>();
        
        if (nums.length == 0) {
            return res;
        }
    
        for (int num : nums) {
            
            int index = Math.abs(num) - 1;
            
            if (nums[index] > 0) {
                nums[index] = - nums[index];
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        
        return res;
    }
}