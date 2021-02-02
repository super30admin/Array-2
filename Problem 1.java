// Time Complexity :O(n+n)=O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
    //1 to n would also signify the index of an array and if the element is present we mark the index as -1;
    //we check for all indexes which are not <0 . Those are the numbers missing.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> out = new ArrayList<>();
        
       for(int i=0;i<nums.length;i++)
       {
           int ind = Math.abs(nums[i])-1;
           if(nums[ind]>0)
               nums[ind]*=-1;
       }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
                out.add(i+1);
        }
           
            
        return out;
    }
}