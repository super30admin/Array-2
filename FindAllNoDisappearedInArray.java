import java.util.List;
import java.util.ArrayList;
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++)
        {
            int numIndex = Math.abs(nums[i]) - 1;
            if(nums[numIndex] > 0)
            {
                nums[numIndex] *= -1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] < 0)
            {
                nums[i] *= -1;
            }
            else
            {
                result.add(i+1);
            }
        }
        return result;
    }
}
