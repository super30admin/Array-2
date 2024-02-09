//SC: O(1)

//TC: O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
           if(nums[i]>0)
           {
            if(nums[nums[i]-1]>0)
            nums[nums[i]-1]=nums[nums[i]-1]*-1;
           }
           else
           {
             if(  nums[-1*nums[i]-1]>0)
             nums[-1*nums[i]-1]=-1*nums[-1*nums[i]-1];
           }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                result.add(i+1);
            }

        }
        return result;
        
    }
}