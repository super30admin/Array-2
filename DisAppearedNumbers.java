// Time Complexity : O(N) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : No.

// Approach:
// 1. Traverse the array, for each number, mark its corresponding index as negative to indicate the number is present.
// 2. After marking, traverse the array again and collect indices where the number is positive, indicating the number is missing.
// 3. Return the list of missing numbers.


import java.util.ArrayList;
import java.util.List;

public class DisAppearedNumbers 
{
    public List<Integer> findDisappearedNumbers(int[] nums) 
    {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[Math.abs(nums[i])-1]>0)
            {
                if(Math.abs(nums[i])-1 <= nums.length-1)
                {
                    nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
                }
            }
        } 
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                li.add(i+1);
            }
        }  
        return li;    
    }
}
