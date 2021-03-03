// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :N/A
// Any problem you faced while coding this :Test cases


// Your code here along with comments explaining your approach
// In this approach we search using pair. We always consider two elements while comparing. We get the max and min from those two numbers and compare
// them to the max and min and assign them to min and max accordingly.

public class MaxMinArray{
    

    public static int[] findMinMax(int[] nums)
    {
    	//edge case
        if(nums == null || nums.length==0)
        {
            return new int[]{-1,-1};
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length;i=i+2)
        {
        	//getting max of the two numbers from the pair we are looking at
           int x = Math.max(nums[i],nums[i+1]);
           	//getting min of the two numbers from the pair we are looking at
           int y = Math.min(nums[i],nums[i+1]);
           
           if(x > max)
           {
               max = x;
           }
           if(y < min)
           {
               min = y;
           }
        }
        
        return new int[]{max,min};
    }

     public static void main(String []args){
         
         int[] nums = new int[] {4,3,2,7,8,2,3,1};
         
         findMinMax(nums);
         
     }
}