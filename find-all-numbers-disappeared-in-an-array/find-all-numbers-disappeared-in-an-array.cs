public class Solution {
    public IList<int> FindDisappearedNumbers(int[] nums) {
        
        for(int i=0;i<nums.Length;i++)
        {
            int temp = Math.Abs(nums[i]) -1;
             if (nums[temp] > 0) nums[temp] = -nums[temp];
            
        }
        
        List<int> list = new List<int>();
        
        for(int i=0;i<nums.Length;i++)
        {
            if (nums[i] > 0) list.Add(i+1);
        }
        
        return list;
        
    }
}
