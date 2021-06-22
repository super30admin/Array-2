// Time Complexity : O(n)), 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No

import java.util.*;
public class Problem1 {
  public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<Integer>();
        if(nums.length == 0 || nums == null) return result; 
        // loop to make terms negative for the values
        for(int i = 0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = -1 * nums[index];
            }
        }
        //check for plus values
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                nums[i] = -1 * nums[i];
            }
            else{
                result.add(i + 1);
            }
        }
        return result;
    }   
}