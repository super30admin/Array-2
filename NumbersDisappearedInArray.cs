// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// 1. Iterate through the array, marking visited numbers by negating values at corresponding indices.
// 2. Traverse the array again, identifying positive values, which indicate missing numbers.
// 3. Add the index of positive values plus one to the result list, representing disappeared numbers.

public class Solution {
    public IList<int> FindDisappearedNumbers(int[] nums) {
        List<int> result = new List<int>();
        int n= nums.Length;
        int idx =0;

        for(int i=0; i<n; i++)
        {
            idx = Math.Abs(nums[i])-1;
            if(nums[idx] >0)
            {
                nums[idx] *= -1;
            }
        }
        for(int i=0; i<n; i++)
        {
            if(nums[i] >0)
            {
                result.Add(i+1);
            }
            else
            {
                nums[i] *= -1;
            }
        }
        return result;
    }
}