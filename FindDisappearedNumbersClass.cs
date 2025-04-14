public class Solution
{
    public IList<int> FindDisappearedNumbers(int[] nums)
    {
        var result = new List<int>();

        for (int i = 0; i < nums.Length; i++)
        {
            var index = Math.Abs(nums[i]);
            if (nums[index - 1] > 0)
            {
                nums[index - 1] *= -1;
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
                nums[i] *= -1;
            }
        }
        return result;
    }
}