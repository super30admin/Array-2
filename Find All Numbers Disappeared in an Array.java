// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
         List<Integer> result=new ArrayList<>();
        //edge
        if(nums==null || nums.length==0) return result;
        int n=nums.length;        
        for(int i=0;i<n;i++)
        {
            int state=Math.abs(nums[i])-1;
            if(nums[state]>0)
            {
                nums[state]*=-1;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
            {
                result.add(i+1);
            }
        }
        return result;
    }
}
