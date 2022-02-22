// Time Complexity : O(n) where n = length of nums array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;
public class Problem1 {
    
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // For each number in the nums array, make the elemnt at the corresponding index negative if it is not already negative.
        for (int num: nums) {
            int ele = Math.abs(num);
            if (nums[ele-1] > 0) {
                nums[ele-1] *= -1;
            }
        }
        // Iterate through the nums array again and return numbers corresponding to indices where the element is still positive.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> ans = findDisappearedNumbers(nums);
        System.out.println(ans);
    }

}
