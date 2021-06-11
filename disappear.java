class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result=new ArrayList<>();
        if(nums==null || nums.length==0)    return result;
        for(int i=0;i<nums.length;i++)
        {
            int index=Math.abs(nums[i])-1;
            if(nums[index]>0)
            {
                nums[index]*=-1;
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                result.add(i+1);
            }
            else
            {
                nums[i]*=-1;
            }
        }
        return result;
    }
}
//time complexity: O(n)+O(n)
//space complexity: O(1)