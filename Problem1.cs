public class DisappearingNumbers
    {
        // Time Complexity : O(n)
        // Space Complexity : O(1) - since we are searching in place
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public IList<int> FindDisappearedNumbers(int[] nums)
        {
            int n = nums.Length;
            IList<int> result = new List<int>();

            //loop through the array to check for existing numbers just like in hashset
            for(int i = 0; i < n; i++)
            {
                int index = Math.Abs(nums[i]) - 1;
                if(nums[index] > 0) //if the number is not negative already
                {
                    nums[index] = nums[index] * -1;
                }
            }

            //loop through the array again to check for missing numbers
            for(int i = 0; i < n; i++)
            {
                if(nums[i] < 0) //if the number is negative already then just make it positive to retain the original array values
                {
                    nums[i] = nums[i] * -1;
                }
                else
                {
                    result.Add(i + 1); // if number is positive then we have not found the index + 1 number anywhere in the array
                }
            }
            return result;
        }
    }
