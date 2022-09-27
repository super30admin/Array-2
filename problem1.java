import java.util.*;
public class problem1 {

// Time Complexity : O(n) where n is number of elements in an array.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
               int idx = Math.abs(nums[i]) - 1;
                 if(nums[idx] > 0){
                    nums[idx] = nums[idx] * -1;
                        }
            }
        
        for(int i=0; i< nums.length; i++){
            if(nums[i] > 0){
                res.add(i + 1);
            }      
        }
         
            return res;
    }
}
