// Time Complexity : O(N) N = length of the array nums
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Consider the array and check for the values which are present and negate the values which are present in the 
//respective indices.
// Checking the indices which has positive values would give the values which are missing.
import java.util.*;

class Disappear {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 0 || nums == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int ind = Math.abs(nums[i]) - 1;
            if (nums[ind] > 0)
                nums[ind] = -nums[ind];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                res.add(i + 1);
        }
        return res;
    }

    public static void main(String args[]) {
        Disappear obj = new Disappear();
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(obj.findDisappearedNumbers(nums));

    }

}