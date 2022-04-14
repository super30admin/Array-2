// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

public int[] FIndMinAndMax(int[] nums)
{
    if(nums == null || nums.Length == 0)
        return new int[]{};

    int min = 0;
    int max = 0;
    for(int i = 0; i < nums.Length - 1; i++)
    {
        //3 comparisons total for each eleemnt
        if(nums[i] > nums[i+1])
        {
            max = Math.Max(max, nums[i]);
            min = Math.Min(min, num[i+1]);
        }
        else
        {
            max = Math.Max(max, nums[i+1]);
            min = Math.Min(min, nums[i+1]);
        }
    }

    return new int[] {min, max};
}