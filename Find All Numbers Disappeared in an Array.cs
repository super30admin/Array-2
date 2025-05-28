/*
  Time complexity:O(n)
  Space complexity:O(1)

  Code ran successfully on Leetcode: Yes

  Approach: The number at the index of the element in the current iteration is negated if greater than 0 to indicate presence. The indexes greater than 0 are then disappeared elements.

*/

public class Solution {
    public IList<int> FindDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.Length;i++)
        {
            int index = Math.Abs(nums[i]) - 1;
            if(nums[index] > 0)
                nums[index]*=-1;
        }

        List<int> result = new List<int>();
        for(int i=0;i<nums.Length;i++)
        {
            if(nums[i]>0)
                result.Add(i+1);
        }
        return result;
    }
}
