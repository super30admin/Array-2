// Time Complexity : O(n), where n is the number of elements in the array
// Space Complexity : O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/**
 * 1. Iterate through the array and mark the index of the number as negative.
 * 2. Iterate through the array again and add the index of the positive numbers to the result list and return it.
 * 3. Positive numbers in the array indicate that the index of the number is missing.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<len; i++){
            int currNum = Math.abs(nums[i]);
            if(nums[currNum-1] > 0){
               nums[currNum-1] *= -1; 
            }
        }

        for(int i=0; i<len; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }

        return list;
    }
}
