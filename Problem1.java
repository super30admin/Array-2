// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class Problem1 {

    // TC - O(N)
    // SC - O(1)

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        for (int x : nums) {
            int num = Math.abs(x) - 1;
            if(nums[num] > 0) nums[num] *= -1;
        }
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0) output.add(i + 1);
        return output;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{
                4,3,2,7,8,2,3,1
        })); // 5,6
    }

}
