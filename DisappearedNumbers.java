// Time Complexity : O(n) [n is length of array]
// Space Complexity : Not used any extra space [used int n to store length of array for ease of writing] 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;

class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // return helperHashSet(nums);
        return helperWithoutExtraSpace(nums);
    }

    public List<Integer> helperWithoutExtraSpace(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        // For all the number found, I'm multiplying it with -1 to make it negative
        // (same as HashSet logic)
        // If number is found twice still making it negative by using Abs value;
        // For value m, i'm making nums[m-1] as negative, In order to handle edge cases
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]);
            nums[idx - 1] = -1 * Math.abs(nums[idx - 1]);
        }

        // For all the positive numbers I'm adding them in the result list
        // Adding one to the idx since idx starts from zero and value starts from 1
        for (int idx = 0; idx < n; idx++) {
            if (nums[idx] == Math.abs(nums[idx])) {
                list.add(idx + 1);
            }
        }

        return list;
    }

    // public List<Integer> helperHashSet(int[] nums) {
    // int n = nums.length;
    // List<Integer> list = new ArrayList<>();

    // boolean[] hset = new boolean[n + 1];

    // for (int i = 0; i < n; i++) {

    // hset[nums[i]] = true;
    // }

    // for (int i = 1; i < hset.length; i++) {
    // if (hset[i] == false) {
    // list.add(i);
    // }
    // }

    // return list;
    // }
}