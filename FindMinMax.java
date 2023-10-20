// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No

public class FindMinMax
{
    public int[] findMinMax2NComparisons(int[] nums)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i< nums.length; i++)
        {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return  new int[]{min, max};
    }
    public int[] findMinMax1HalfNComparisons(int[] nums)
    {
        int min = nums[0];
        int max = nums[0];
        int n =  nums.length-1;

        for(int i = 1; i< n; i = i+2)
        {
            if(nums[i] > nums[i+1]) {
                max = Math.max(max ,nums[i]);
                min = Math.min(min ,nums[i+1]);
            }
            else {
                max = Math.max(max ,nums[i+1]);
                min = Math.min(min ,nums[i]);
            }
        }
        max = Math.max(max ,nums[nums.length-1]);
        min = Math.min(min ,nums[nums.length-1]);

        return  new int[]{min, max};
    }
}
