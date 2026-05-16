// Time Complexity : O(n) where n is the total length of nums array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    public IList<int> FindDisappearedNumbers(int[] nums) {
        List<int> result = new();
        
        for(int i = 0; i < nums.Length; i++)
        {
            int index = Math.Abs(nums[i]) - 1;
            
            if(nums[index] > 0) 
            {
                nums[index] *= -1;
            }
        }

        for(int i = 0; i < nums.Length; i++)
        {
            if(nums[i] > 0)
            {
                result.Add(i+1);
            }
        }

        return result;
    }
}