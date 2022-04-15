using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    public class DisappearedNumbers
    {
        /*
         * T.C O(N) : as we traverse through all elements of the array
         * S.C O(1) : no additional space used and result is expected to return so it doesn't count as extra space
         * run on Leetcode: Yes
         */
        public IList<int> FindDisappearedNumbers(int[] nums)
        {

            IList<int> result = new List<int>();
            int index = 1;

            // trverse through all elements in the array and on each index mark element as -ve which represent element found
            for (int i = 0; i < nums.Length; i++)
            {
                index = Math.Abs(nums[i]) - 1;

                if (nums[index] < 0)
                    continue;
                else
                    nums[index] = nums[index] * -1;
            }

            //reverse the -ve value to its original value as follow up and add non negative numbers index+1 as disappeared numbered
            for (int i = 0; i < nums.Length; i++)
            {
                if (nums[i] < 0)
                    nums[i] = nums[i] * -1;
                else
                    result.Add(i + 1);
            }

            return result;
        }
    }
}
