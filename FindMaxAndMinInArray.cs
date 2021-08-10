using System;
using System.Collections.Generic;
using System.Text;

namespace LeetCodeSuper30
{
    class FindMaxAndMinLC
    {
        //Time Complexity: O(n)
        //Space Complexity: O(1)
        public int[] FindMaxAndMin(int[] nums)
        {
            if (nums == null || nums.Length == 0)
            {
                return new int[]{};
            }
            int max = int.MaxValue;
            int min = int.MinValue;
            for (int i = 0; i < nums.Length - 1; i++)
            {
                if (nums[i] > nums[i + 1])
                {
                    max = Math.Max(max, nums[i]);
                    min = Math.Min(min, nums[i + 1]);
                }
                else if (nums[i] < nums[i + 1])
                {
                    max = Math.Max(max, nums[i + 1]);
                    min = Math.Min(min, nums[i]);
                }
                else if (i == nums.Length - 1)
                {
                    max = Math.Max(max, nums[i]);
                    min = Math.Min(min, nums[i]);
                }
            }
            return new int[2] { max, min };
        }
         
    }

}
