// Time Complexity : O(n) where n is the number of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for(int i:nums)
        {   if(i<0) i*=-1;
            if(nums[i-1]>0)
            nums[i-1]= -1*nums[i-1];
        }
        
        for(int i =1;i<=nums.length;i++)
        {
            if(nums[i-1]>0)
                res.add(i);
            else
                nums[i-1]*=-1;
        }
        return res;
    }
}