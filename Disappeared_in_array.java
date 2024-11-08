// Time Complexity :O(2n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// approach: first we iterate through the array, take each number and make its index negative, so that we know that the 
//number which is negative has its element in the array. the value which is not negative indicates that the number which needs
// to be in its index is not present and we add into a list.

// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;

public class Disappeared_in_array {
    class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int abs=Math.abs(nums[i]);
            if(nums[abs-1]>0)
            {
                nums[abs-1]*=-1;
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                nums[i]*=-1;
            }
            else
                arr.add(i+1);
        }
        return arr;
    }
}
}
