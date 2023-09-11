// Time Complexity : O(N)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode :yes

/*
 * as the range is 1 to n change the respective value -1 to negative value to show that specific number is present 
 * in second iteration add the numbers which are positive(missing) to the result list
 */

import java.util.*;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i <n; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = - nums[index];
            }
        }

        for(int i=0; i< n; i++){
            if(nums[i] > 0)
                result.add(i + 1);
        }

        return result;
    }
}