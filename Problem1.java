// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: I used an extra array where i had put each value to its index and then checked where the index was 0. If zero then added the index+1 to the list and then returned the list

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> al = new ArrayList<>();
        int[] arr = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            if (arr[nums[i] - 1] == 0) {
                System.out.println("Check" + arr[nums[i] - 1]);
                arr[nums[i] - 1] = nums[i];
                System.out.println("add" + arr[nums[i] - 1]);
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                al.add(i + 1);
            }
            System.out.println("Check" + arr[i]);
        }

        return al;

    }
}