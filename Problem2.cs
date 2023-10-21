public class MinMaxUsingMinComparison
    {
        // Time Complexity : O(n)- For every pair 3 comparisons so total number of comparisons is 3 * n/2 = 1.5n
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Not available on leet code
        // Any problem you faced while coding this : No
        public int[] MinMax(int[] nums)
        {
            int n = nums.Length;
            int min = nums[0];
            int max = nums[0];
            int i = 1;
            int j = i + 1;
            //compare in pairs
            while(j < n-1 || j < n)
            {
                if(nums[i] < nums[j])
                {
                    min = Math.Min(min, nums[i]);
                    max = Math.Max(max, nums[j]);
                }
                else
                {
                    min = Math.Min(min, nums[j]);
                    max = Math.Max(max, nums[i]);
                }
                i = i + 2;
                j = i + 1;
            }
            //if array is even length compare the last remaining number
            if(n%2 == 0)
            {
                min = Math.Min(min, nums[n-1]);
                max = Math.Max(max, nums[n-1]);
            }

            return new int[] { min, max };
        }
    }
