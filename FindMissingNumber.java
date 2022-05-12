/**

https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Given an array nums of n integers where nums[i] is in the range [1, n], 
return an array of all the integers in the range [1, n] that do not appear in nums.

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]



Solution:
    - its given that all the elements are positive
    - Loop over the input array and for each elemement value multiply the value at index by -1 if it is not -ve
    
     for(int i =0;  i < nums.length; i++)
     {
         int index = nums[i] -1;
         if(nums[index] > 0)
         {
             nums[index] = *(-1);
         }
         // [-4,-3,-2,-7,8,2,-3,-1]
         
         // the loop over the input array to check for the +ve value index and add it to the output
     }

Time Complexity : O(N) N = input size
Space Complexity : O(1) = input size
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/
class Solution 
{
    public List<Integer> findDisappearedNumbers(int[] nums) 
    {
        List<Integer> output = new ArrayList<>();
        
        if( nums == null || nums.length ==0)
            return output;
            
        for(int i=0; i< nums.length; i++)
        {
            int index = Math.abs(nums[i]) -1;
            if(nums[index] > 0)
                nums[index] = *(-1);
        }
        
        for(int i=0; i< nums.length; i++)
        {
            if(nums[i] > 0)
                output.add(i+1);
        }
        
        return output; 
    }
}