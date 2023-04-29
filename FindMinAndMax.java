// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
/*
 * Aproach: we could keep a track of min and max and traverse whole array. No. of comparison 2*n. To reduce comparisons,
 * we compare pairs of nums, whichever is lesser gets compared to min and greater to max. Now total comparisons would be 1.5*n
 */

import java.util.Arrays;

public class FindMinAndMax {
    public int[] findMinAndMax(int[] nums) {
        if(nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }
        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i+=2) {
            if(nums[i] > nums[i-1]) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i-1]);
            }
            else {
                max = Math.max(max, nums[i+1]);
                min = Math.min(min, nums[i]);
            }
        }
        if(nums.length % 2 != 0) {
            max = Math.max(max, nums[nums.length - 1]);
            min = Math.min(min, nums[nums.length - 1]);
        }

        return new int[]{max, min};
    }

    public static void main(String[] args) {
        int[] input = {2};
        FindMinAndMax f = new FindMinAndMax();
        System.out.println(Arrays.toString(f.findMinAndMax(input)));
    }
}
