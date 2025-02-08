// time complexity - O(n)
// space complexity - O(1)
// Changed the element state in place and moved it back after computation
public class Solution
{
    public IList<int> FindDisappearedNumbers(int[] nums)
    {
        int n = nums.Length;
        IList<int> res = new List<int>();
        for (int i = 0; i < nums.Length; i++)
        {
            int idx = Math.Abs(nums[i]) - 1;
            if (nums[idx] > 0)
            {
                nums[idx] *= -1;
            }
        }
        for (int i = 0; i < nums.Length; i++)
        {
            if (nums[i] > 0)
            {
                res.Add(i + 1);
            }
            else
            {
                nums[i] *= -1;
            }
        }
        return res;
    }
}