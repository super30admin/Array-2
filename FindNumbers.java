// Time Complexity : O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class FindNumbers{
  public List<Integer> findDisappearedNumbers(int[] nums)
   {
       
     ArrayList<Integer>l =new ArrayList<Integer>();

     // Number i should be at Index i-1. Find absolute position of number and make it -ve.
    
    for(int i=0;i<nums.length;i++)
    {
        int pos=Math.abs(nums[i])-1;
        
        if(nums[pos]>0)
            nums[pos]*=-1;
    }
       
    // Only the numbers which are -ve, it means the index is never visited. It means number index + 1 is missing.
      for(int i=0;i<nums.length;i++)
    {
        if(nums[i]>0)
            l.add(i+1);
    }  
    
        return l;}
        
} 