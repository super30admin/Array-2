//Time Complexity: O(n)
//Space Complexity: O(1)

import java.util.ArrayList;
import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return new ArrayList<>();
        }   

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i< nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }

            else {
                nums[i] = nums[i] * -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = new ArrayList<>();
        res = sol.findDisappearedNumbers(nums);
        System.out.println(res);
    }
}

