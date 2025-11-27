// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
I can use the element of the nums and go to its respective idx and change it value to negative.
In the 2nd pass, I will check if there are any numbers where are positive. 
If there are it means that these index ~ numbers are missing 
*/

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i = 0;i<nums.length;i++) {
            int idx = Math.abs(nums[i]);
            if(nums[idx-1] > 0) {
                nums[idx-1] *= -1;
            }
        }

        for(int i = 0;i<nums.length;i++) {
            if(nums[i] > 0) {
                res.add(i+1);
            } else {
                nums[i] *= -1;
            }
        }

        return res;
    }
}
