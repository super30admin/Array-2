using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class Array_FindDisappearedNumbers
    {
        /// Time Complexity : O(N) 
        // Space Complexity :O(N) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No
        public IList<int> FindDisappearedNumbers(int[] nums)
        {

            HashSet<int> set = new HashSet<int>();
            List<int> result = new List<int>();
            for (int i = 0; i < nums.Length; i++)
            {
                if (!set.Contains(nums[i]))
                {
                    set.Add(nums[i]);
                }
            }

            for(int i = 1; i <= nums.Length; i++)
            {
                if (!set.Contains(i))
                {
                    result.Add(i);
                }
            }

            return result;
        }

        /// <summary>
        /// State Change
        /// Space Complexity O(1)
        /// </summary>
        /// <param name="nums"></param>
        /// <returns></returns>
        public IList<int> FindDisappearedNumbers_StateChange(int[] nums)
        {
            List<int> result = new List<int>();

            for(int i= 0; i < nums.Length; i++)
            {
                int index = Math.Abs(nums[i]) - 1;
                if (nums[index] > 0) nums[index] *= -1;
            }

            for (int i = 0; i < nums.Length; i++)
            {
                if(nums[i] < 0)
                {
                    nums[i] *= -1;
                }
                else
                {
                    result.Add(i + 1);
                }
            }


            return result;

        }
    }
}
