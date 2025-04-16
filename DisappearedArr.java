// in a single pass we can go over all nums and mark the pos if not present(-ve)
// in second pass we can iterate over arr and check if num are +ve, if yes then add to result

// Time : O(n)
// Space : O(1) 

import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++) {
            int num = nums[i];
            int idx = Math.abs(nums[i]) - 1;

            if(nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(nums[i] > 0) {
                result.add(i+1);
            }else {
                nums[i] *= -1;
            }
        }
        return result;
    }
}