public class Solution {
    public IList<int> FindDisappearedNumbers(int[] nums) {
        List<int> result = new List<int>();
        for(var i=0;i<nums.Length;i++)
        {
            int num = Math.Abs(nums[i]);
            if(nums[num-1]>=0)
            {
                nums[num-1] = -nums[num-1];
            }
        }
        for(var j=0;j<nums.Length;j++)
        {
            if(nums[j]>0)
            {
                result.Add(j+1);
            }
        }
        return result;
        
    }
}