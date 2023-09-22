// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/1054764757/
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Traverse through the indices, and get the index by subtracting 1 from value at index
 * After reaching the index make it negative
 * Whichever indices are positive those are not traversed indicates that the elements are missing
 */
import java.util.*;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums== null || nums.length == 0)
            return new ArrayList<>();
        for(int i=0; i< nums.length ; i++){
            int value = Math.abs(nums[i])-1;
            if(nums[value] > 0)
                nums[value] = nums[value] * -1;
            else
                continue;
        
        }
        for(int i=0; i<nums.length; i++){
            
            if(nums[i]>0)
                result.add(i+1);
            
        }
        return result;
    }
}