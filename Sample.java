//****448.FIND ALL NUMBERS DISAPPEARED IN ARRAY****
// Time Complexity :O(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :N

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result=new ArrayList<>();
        int n= nums.length;
        if(nums.length==0 || nums==null) 
        {
            return result;
        }
        
        for(int i=0;i<n;i++)
        {
            int temp=Math.abs(nums[i])-1;
            
                if(nums[temp]>0)
                {
                    nums[temp] *= -1;
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
// Your code here along with comments explaining your approach
