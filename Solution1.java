// Time complexity: O(N), where N is the length of nums array.
// Space complexity: O(1), no extra space is used.

import java.util.*;

class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int num: nums){
            int index = Math.abs(num)-1;
            if(nums[index] > 0) nums[index] *= -1;
        }
        
        List<Integer> output = new ArrayList<>(); 
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) output.add(i+1); 
        }
        
        return output; 
    }
}