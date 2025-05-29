//make element at index of element negative. Compare with the absolute value!
//answer is the index of the positive elements
//Time complexity: O(n)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            int idx=Math.abs(nums[i]);
            if(nums[idx-1]>=0) {
                nums[idx-1] = -1 * nums[idx-1];
            }
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>0) {
                result.add(i+1);
            }
        }
        return result;
    }
}