// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            //fetch the original index of number
            //for 4 ,it would be 3 in  final array
            int index=Math.abs(nums[i])-1;
            if(nums[index]>0)
            {
                nums[index]=nums[index]*-1;
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)//element not positive
            {
                result.add(i+1);//its next element is not present
            }
        }
        return result;
    }
}