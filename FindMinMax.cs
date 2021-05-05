using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithms
{
    public class FindMinMax
    {
        //Time Complexity  - 2*O(n) - Since we are doing 2 comparisions for each element in the array
        // Space Complexity - O(1) - Since we are not using any extra space
        public void FindMinMaxWithFourSteps(int[] nums)
        {
            var min = nums[0];
            var max = nums[0];

            // For every element there are 2 comparisions - Total 2n steps
            for(int i = 1; i < nums.Length; i++)
            {
                min = Math.Min(min, nums[i]);
                max = Math.Max(max, nums[i]);
            }

            Console.WriteLine("Min :{0}", min);
            Console.WriteLine("Max: {0}", max);
        }

        //Time Complexity  - 3n/2 = 1.5 * O(n) - Since we have 3 comparisions and are iterating in pairs
        //Space complexity - O(1) - Since we are not using any extra space
        public void FindMinMaxWithThreeSteps(int[] nums)
        {
            var min = int.MaxValue;
            var max = int.MinValue;

            // One comaprision between current element and next element, the other Two comparisions between Min and max and these elements
            // Total 3 steps 
            
            for (int i = 0; i < nums.Length - 1; i++)
            {
                if(nums[i] < nums[i + 1])
                {
                    min = Math.Min(nums[i], min); 
                    max = Math.Max(nums[i + 1], max);
                }
                else
                {
                    min = Math.Min(nums[i + 1], min);
                    max = Math.Max(nums[i], max);
                }
            }

            Console.WriteLine("Min :{0}", min);
            Console.WriteLine("Max: {0}", max);
        }
    }
}
