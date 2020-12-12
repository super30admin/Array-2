// Time Complexity : O(N) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// In first pass mark visited numbers with -ve, that means we have seen this
// num before. In next pass iterate again anfd find out the which indicies are not marked -ve and return.

import java.util.*;
class FindDisappearedNumSolution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums==null || nums.length==0)
            return result;
        for(int i=0; i<nums.length; i++) {
            int cur = Math.abs(nums[i]);
            nums[cur-1] = -Math.abs(nums[cur-1]);
        }
        for(int i=0 ;i<nums.length; i++) {
            if(nums[i]>0)
                result.add(i+1);
        }
        return result;
    }
}