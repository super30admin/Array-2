//Leetcode Problem : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I traverse through the whole array once and check if nums[Math.abs(nums[i])-1] is greater than 0, if so then I multiply 
 * that number into -1. I traverse through the array and check for any elements which are greater than 0, if so 
 * I add i+1 to final array.
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[Math.abs(nums[i])-1]>0)
            {
                nums[Math.abs(nums[i])-1] *=-1;
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                ans.add(i+1);
            }
        }
        return ans;
    }
}