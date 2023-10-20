// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.ArrayList;
import java.util.List;

public class FindMissingNumbers
{
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums)
        {
            List<Integer> ans = new ArrayList();
            for(int i=0; i < nums.length; i++)
            {
                int idx = Math.abs(nums[i])-1;
                if(nums[idx] > 0)
                    nums[idx] = nums[idx] * -1;
            }
            for(int i=0; i < nums.length; i++)
            {
                if(nums[i] > 0)
                    ans.add(i+1);
            }
            return ans;
        }
    }
}
