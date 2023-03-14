import java.util.*;
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]) - 1;
            if( nums[x] > 0 ) {
                nums[x] = nums[x]*-1;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if( nums[i] < 0 ) {
                nums[i] = nums[i]*(-1);
            } else {
                list.add(i+1);
            }
        }
        return list;
    }
}
