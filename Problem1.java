// Time Complexity : O(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
 * Approach is to  make corresponding index of that number in an array  negative
 * like--- 4 number --- make (4-1) index number negative
 * then serach which index number is positive 
 * suppose 4 th index is positive then return 5 is missing
 * 
 */

 class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i< n; i++)
        {
            int  idx = Math.abs(nums[i]) - 1;  
            if(nums[idx] > 0){    
                nums[idx] *= -1;
            }
        }
        for(int i = 0; i< n; i++)
        {
            if(nums[i] > 0)
                result.add(i+1);
            else nums[i] *= -1;
        }
        return result;
    }
}