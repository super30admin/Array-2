// Time Complexity : O(n)  n=number of elements in array.
// Space Complexity :O(1)   
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int length=nums.length;
        int index;
        for(int i=0;i<length;i++)
        {
        	
        	index=Math.abs(nums[i])-1;
        	if(nums[index]>0)
        	{
            nums[index]*=-1;
        	}
        }       
        for(int i=0;i<length;i++)
        {
            if(nums[i]>0)
            {
                result.add(i+1);
            }
        }
        
        return result;
    }
}