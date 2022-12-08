// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.*;

class FindDisappeartedNum {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            nums[idx] = Math.abs(nums[idx]) * -1;
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i] > 0) ll.add(i+1);
        }
        return ll;
    }
}