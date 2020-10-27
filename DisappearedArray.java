// Time Complexity = o(n)
// Space Complexity = o(1)

import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int newIndex = Math.abs(nums[i]) -1;
            if(nums[newIndex] > 0){
                nums[newIndex] = nums[newIndex] * -1;
            }
        }
        List<Integer> l = new LinkedList<>();
        for( int i = 1; i <= nums.length; i++){
            if(nums[i-1] > 0){
                l.add(i);
            }
        }
        return l;
     }
}