class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        
        for(int i=0;i<n;i++)
        {
            int idx=Math.abs(nums[i])-1;
            nums[idx]=-1*Math.abs(nums[idx]);
            
        }
        
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
                result.add(i+1);
        }
        
        return result;
    }
}

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no