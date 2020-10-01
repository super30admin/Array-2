// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> output = new ArrayList<>();
        if(nums == null || nums.length==0)
            return output;
        
        for(int i=0;i<nums.length;i++)
        {
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] > 0)
            {
                nums[idx] = -nums[idx];
            }
        }
        
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] > 0)
                output.add(i+1);
        }
        return output;
    }
}