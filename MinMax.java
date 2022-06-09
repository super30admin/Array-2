// Time Complexity : O(n) where n is the length of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class MinMax {
    public int[] findminmax(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for(int i=0;i<nums.length;i+=2){
            if (nums[i] > nums[i+1]) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i+1]);
            } else {
                max = Math.max(max, nums[i+1]);
                min = Math.min(min, nums[i]);
            }
        }

        return new int[]{max,min};
    }

    public static void main(String [] args){
        int [] nums = new int[]{4,3,2,7,8,2,3,1};
        MinMax mm = new MinMax();
        System.out.println(Arrays.toString(mm.findminmax(nums)));
    }
}