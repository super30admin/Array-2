//TC: O(N) SC: O(1)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) -1;
            if(nums[idx] > 0) nums[idx] *= -1;
        }

        for(int i = 0; i < nums.length; i++) {
            
            if(nums[i] > 0) res.add(i+1);
            else nums[i] *= -1;
        }

        return res;
    }
}