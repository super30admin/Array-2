// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list= new ArrayList<Integer>();

        for(int i=0; i< nums.length; i++)
        {
            int indx = 0;
            indx = Math.abs(nums[i]) - 1;   // number can be negative so take absolute
            if(nums[indx]>0) // If already made negative dont do anything probably the repeated number 
             nums[indx]*= -1; // if not negative make it negative
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0 )     
            list.add(i+1); // any positive values? that means the element at that index is missing
            else
            nums[i]*= -1;  // restore original array
            
        }
        return list;
    }
}