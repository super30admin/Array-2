// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for(int i =0;i<n; i++)
        {
            int temp = Math.abs(nums[i])-1;
            if(nums[temp]>0)
            {
                nums[temp] = -nums[temp];
            }
        }
        
        for(int i =0;i<n; i++)
        {
            if(nums[i]>0)
            {
                result.add(i+1); 
            }
        }
        return result;
    } 
}