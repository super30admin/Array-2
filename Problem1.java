// Time Complexity : 
//      findDisappearedNumbers() - O(n)
//      
// Space Complexity :
//      findDisappearedNumbers() - O(1)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        
        for(int i=0; i < nums.length; ++i)
        {
            int idx = Math.abs(nums[i]) - 1;
            
            nums[idx] = (nums[idx] > 0) ? -nums[idx] : nums[idx];
        }
        
        List<Integer> li = new ArrayList<>();
        
        for(int i=0; i< nums.length; ++i)
        {
            if(nums[i] > 0)
            {
                li.add(i+1);
            }
        }
        
        return li;
    }
}