import java.util.*;
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
public class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums==null || nums.length==0)
            return new ArrayList<>();
        List<Integer> result= new ArrayList<>();
        // marking the index visited by the number it is supposed to contain
        for(int i=0;i<nums.length;i++){
            int idx= Math.abs(nums[i]);
            if(nums[idx-1]>0)
                nums[idx-1]=-1*nums[idx-1];
        }
        // checking which indices were not touched
        // changing back to the original array
       for(int i=0;i<nums.length;i++){
           if(nums[i]<0)
               nums[i]=-1*nums[i];
           else
               result.add(i+1);
       }
        return result;
    }
}
