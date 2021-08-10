using System;
using System.Collections.Generic;
using System.Text;

namespace LeetCodeSuper30
{
    class FindDisappearedNumbersLC
    {
        //Time Complexity: O(n)
        //Space Complexity: O(1)
        public List<int> FindDisappearedNumbers(int[] nums)
        {
            if (nums == null || nums.Length == 0)
            {
                return new List<int>();
            }
            List<int> result = new List<int>();
            for (int i = 0; i < nums.Length; i++)
            {
                int index = Math.Abs(nums[i]) - 1;
                if (nums[index] > 0)
                {
                    nums[index] = nums[index] * -1;
                }
            }
            for (int i = 0; i < nums.Length; i++)
            {
                if (nums[i] > 0)
                {
                    result.Add(i + 1);
                }
                else
                {
                    nums[i] = nums[i] * -1;
                }
            }
            return result;
        }
    }
}
