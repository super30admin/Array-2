import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I iterate through the array once and get the index of the element as absolute value of (nums[i]) - 1. If element at that index is not negative, I multiply it with -1.
 * After performing this for all elements, the index of elements which are positive + 1 are the missing numbers.
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums==null || nums.length==0)
        {
            return ans;
        }
        for(int i=0;i<nums.length;i++)
        {
            int index=Math.abs(nums[i])-1;
            if(nums[index]>0)
            {
                nums[index]*=-1;
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