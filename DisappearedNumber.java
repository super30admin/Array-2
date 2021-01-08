// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> output = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)                       // Mark indices by making terms negative
        {
            if(nums[Math.abs(Math.abs(nums[i])-1)]>0)
            {
                nums[Math.abs(Math.abs(nums[i])-1)]*=-1;
            }
        }
        
        for(int i=0;i<nums.length;i++)         // add indices of positive numbers to output      
        {
            if(nums[i]>0)
            {
                output.add(i+1);
            }
        }
       
        return output;
    }
}