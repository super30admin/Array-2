// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: // 1. Iterate through the array and for each number, mark the indices as negative. // 2. Iterate through the array and find the indices which are positive. Those are the missing numbers.

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return list;
        }

        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;


            if(nums[index] > 0){
                nums[index] = -1 * nums[index];
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }

        return list;
    }

}
